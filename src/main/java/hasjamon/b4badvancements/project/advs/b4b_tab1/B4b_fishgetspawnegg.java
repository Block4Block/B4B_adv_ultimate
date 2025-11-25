package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerFishEvent;

public class B4b_fishgetspawnegg extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_fishgetspawnegg");


  public B4b_fishgetspawnegg(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.TROPICAL_FISH_SPAWN_EGG, "Tropical Caviar", AdvancementFrameType.TASK, true, true, 3f, 0f , "Catch a Tropical Fish Spawn Egg while Fishing."), parent, 1);

    registerEvent(PlayerFishEvent.class, (e) -> {
      if (e.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
        if (e.getCaught() != null && e.getCaught().getType() == EntityType.ITEM) {
          Material itemType = ((Item) e.getCaught()).getItemStack().getType();

          if (itemType == Material.TROPICAL_FISH_SPAWN_EGG) {
            Player p = e.getPlayer();
            incrementProgression(p);
          }
        }
      }
    });
  }
}