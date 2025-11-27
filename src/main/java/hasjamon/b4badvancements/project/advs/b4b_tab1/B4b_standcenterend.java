package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import org.bukkit.Location;
import org.bukkit.World;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

public class B4b_standcenterend extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_standcenterend");


  public B4b_standcenterend(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.GOLDEN_BOOTS, "Origin of The Big Bang", AdvancementFrameType.TASK, true, true, 4f, 15f, "Travel to the center of the End."), parent, 1);

    registerEvent(PlayerMoveEvent.class, (e) -> {
      Player p = e.getPlayer();
      Location loc = p.getLocation();

      // Check if player is in the End dimension
      if (loc.getWorld().getEnvironment() == World.Environment.THE_END) {
        int x = loc.getBlockX();
        int z = loc.getBlockZ();

        // Check if standing at X=0 and Z=0
        if (x == 0 && z == 0) {
          incrementProgression(p);
        }
      }
    });
  }
}