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

public class B4b_makebook extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_makebook");


  public B4b_makebook(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.BOOK, "Bookworm", AdvancementFrameType.TASK, true, true, 3f, 0f, "Craft a Book."), parent, 1);
    registerEvent(CraftItemEvent.class, (event) -> {
      if (event.getWhoClicked() instanceof Player player) {
        ItemStack result = event.getRecipe().getResult();

        if (result.getType() == Material.BOOK) {
          incrementProgression(player);
        }
      }
    });
  }
}