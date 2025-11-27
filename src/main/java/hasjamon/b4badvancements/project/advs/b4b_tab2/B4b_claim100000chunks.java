package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import hasjamon.block4block.events.PlayerClaimsCountedEvent;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;

public class B4b_claim100000chunks extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_claim100000chunks");


  public B4b_claim100000chunks(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.DIAMOND_BLOCK, "Emperor", AdvancementFrameType.TASK, true, true, 14f, 6f, "Own 100000 claims."), parent, 1);
    registerEvent(PlayerClaimsCountedEvent.class, (e) -> {
      Player p = e.player;

      if (e.numClaims >= 100000) {
        incrementProgression(p);
      }
    });
  }
}