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

public class B4b_fishgetrarestuff extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_fishgetrarestuff");


  public B4b_fishgetrarestuff(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.NAUTILUS_SHELL, "Exotic Fishing", AdvancementFrameType.TASK, true, true, 4f, 0f , "Catch a rare fishing reward."), parent, 1);

    registerEvent(PlayerFishEvent.class, (e) -> {
      if (e.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
        if (e.getCaught() != null && e.getCaught().getType() == EntityType.ITEM) {
          Material itemType = ((Item) e.getCaught()).getItemStack().getType();

          if (itemType == Material.NAME_TAG || itemType == Material.NAUTILUS_SHELL) {
            Player p = e.getPlayer();
            incrementProgression(p);
          }
        }
      }
    });
  }
}