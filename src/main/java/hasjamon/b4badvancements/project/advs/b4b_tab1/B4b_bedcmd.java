package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import org.bukkit.Location;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerRespawnEvent;

public class B4b_bedcmd extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_bedcmd");


  public B4b_bedcmd(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.WHITE_BED, "Emergency Bed", AdvancementFrameType.TASK, true, true, 3f, 13f, "Respawn without a bed set to get a free bed; available once a day"), parent, 1);

    registerEvent(PlayerRespawnEvent.class, (e) -> {
      Player p = e.getPlayer();
      Location bedSpawn = p.getBedSpawnLocation();

      // Check if player doesn't have a bed spawn location set
      if (bedSpawn == null && !e.isBedSpawn()) {
        incrementProgression(p);
      }
    });
  }
}