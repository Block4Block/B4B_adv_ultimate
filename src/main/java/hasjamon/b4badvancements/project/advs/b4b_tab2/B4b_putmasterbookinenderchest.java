package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class B4b_putmasterbookinenderchest extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_putmasterbookinenderchest");


  public B4b_putmasterbookinenderchest(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.ENDER_CHEST, "Safekeeping", AdvancementFrameType.TASK, true, true, 8f, 8f, "Put an original Master Book in an Ender Chest."), parent, 1);

    registerEvent(InventoryClickEvent.class, (e) -> {
      if (!(e.getWhoClicked() instanceof Player)) {
        return;
      }

      Player p = (Player) e.getWhoClicked();

      // Check if the inventory is an ender chest
      if (e.getInventory().getType() != InventoryType.ENDER_CHEST) {
        return;
      }

      // Get the item being placed (cursor item for placing, current item for shift-clicking)
      ItemStack item = e.getCursor();

      // If cursor is empty, check if shift-clicking from another inventory
      if (item == null || item.getType() == Material.AIR) {
        item = e.getCurrentItem();
      }

      if (item == null || item.getType() != Material.WRITTEN_BOOK) {
        return;
      }

      if (item.hasItemMeta() && item.getItemMeta() instanceof BookMeta) {
        BookMeta meta = (BookMeta) item.getItemMeta();

        // Check if it's NOT a copy (originals either have no generation or ORIGINAL generation)
        // Copies will have COPY_OF_ORIGINAL or COPY_OF_COPY generation
        if (meta.hasGeneration() &&
                (meta.getGeneration() == BookMeta.Generation.COPY_OF_ORIGINAL ||
                        meta.getGeneration() == BookMeta.Generation.COPY_OF_COPY ||
                        meta.getGeneration() == BookMeta.Generation.TATTERED)) {
          return; // This is a copy, not an original
        }

        // Check if it has Master Book lore
        if (meta.hasLore()) {
          for (String line : meta.getLore()) {
            String strippedLine = line.replaceAll("§[0-9a-fk-or]", "");

            if (strippedLine.contains("Master Book") && strippedLine.contains("#")) {
              incrementProgression(p);
              return;
            }
          }
        }
      }
    });
  }
}