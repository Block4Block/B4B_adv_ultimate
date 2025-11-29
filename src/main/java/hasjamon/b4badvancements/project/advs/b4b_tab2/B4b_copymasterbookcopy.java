package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class B4b_copymasterbookcopy extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_copymasterbookcopy");


  public B4b_copymasterbookcopy(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.ENCHANTED_BOOK, "I Heard You Like Copies", AdvancementFrameType.TASK, true, true, 7f, 8f, "Create a copy of copy of a Master Book."), parent, 1);

    registerEvent(CraftItemEvent.class, (e) -> {
      if (!(e.getWhoClicked() instanceof Player)) {
        return;
      }

      Player p = (Player) e.getWhoClicked();

      ItemStack result = e.getInventory().getResult();

      if (result == null || result.getType() != Material.WRITTEN_BOOK) {
        return;
      }

      if (result.hasItemMeta() && result.getItemMeta() instanceof BookMeta) {
        BookMeta meta = (BookMeta) result.getItemMeta();

        // Check generation - "Copy of a copy" is COPY_OF_COPY
        if (meta.hasGeneration() && meta.getGeneration() == BookMeta.Generation.COPY_OF_COPY) {
          if (meta.hasLore()) {
            for (String line : meta.getLore()) {
              // Strip color codes before checking
              String strippedLine = line.replaceAll("§[0-9a-fk-or]", "");

              if (strippedLine.contains("Master Book") && strippedLine.contains("#")) {
                incrementProgression(p);
                return;
              }
            }
          }
        }
      }
    });
  }
}