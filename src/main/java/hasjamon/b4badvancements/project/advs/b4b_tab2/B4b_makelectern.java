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

public class B4b_makelectern extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_makelectern");


  public B4b_makelectern(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.BOOKSHELF, "Lectern Lecture", AdvancementFrameType.TASK, true, true, 4f, 0f, "Craft a Lectern."), parent, 1);
    registerEvent(CraftItemEvent.class, (event) -> {
      if (event.getWhoClicked() instanceof Player player) {
        ItemStack result = event.getRecipe().getResult();

        if (result.getType() == Material.LECTERN) {
          incrementProgression(player);
        }
      }
    });
  }
}