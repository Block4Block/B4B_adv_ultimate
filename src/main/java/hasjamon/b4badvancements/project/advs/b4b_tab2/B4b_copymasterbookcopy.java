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
      ItemStack result = e.getRecipe().getResult();

      // Check if the crafted item is a written book
      if (result.getType() != Material.WRITTEN_BOOK) {
        return;
      }

      // Check if it has book meta with lore
      if (result.hasItemMeta() && result.getItemMeta() instanceof BookMeta) {
        BookMeta meta = (BookMeta) result.getItemMeta();

        if (meta.hasLore()) {
          boolean hasCopyOfCopy = false;
          boolean hasMasterBook = false;

          for (String line : meta.getLore()) {
            if (line.contains("Copy of a copy")) {
              hasCopyOfCopy = true;
            }
            if (line.contains("Master Book #")) {
              hasMasterBook = true;
            }
          }

          if (hasCopyOfCopy && hasMasterBook) {
            incrementProgression(p);
          }
        }
      }
    });
  }
}