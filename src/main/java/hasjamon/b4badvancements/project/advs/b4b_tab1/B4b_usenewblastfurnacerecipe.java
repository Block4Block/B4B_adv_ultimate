package hasjamon.b4badvancements.project.advs.b4b_tab1;

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

public class B4b_usenewblastfurnacerecipe extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_usenewblastfurnacerecipe");


  public B4b_usenewblastfurnacerecipe(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.BLAST_FURNACE, "Stone Blaster", AdvancementFrameType.TASK, true, true, 5f, 11f, "Smelt Cobblestone or Cobbled Deepslate using a Blast Furnace."), parent, 1);

    registerEvent(InventoryClickEvent.class, (e) -> {
      if (!(e.getWhoClicked() instanceof Player)) return;
      Player p = (Player) e.getWhoClicked();

      // Check if clicking in a blast furnace inventory
      if (e.getInventory().getType() == InventoryType.BLAST_FURNACE) {
        // Check if placing item in the input slot (slot 0)
        if (e.getSlot() == 0) {
          ItemStack clicked = e.getCursor();
          if (clicked != null && (clicked.getType() == Material.COBBLESTONE || clicked.getType() == Material.COBBLED_DEEPSLATE)) {
            incrementProgression(p);
          }
        }
      }
    });
  }
}