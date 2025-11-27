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

public class B4b_claim50chunks extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_claim50chunks");


  public B4b_claim50chunks(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.BRICK_WALL, "Baron", AdvancementFrameType.TASK, true, true, 8f, 6f, "Own 50 claims."), parent, 1);
    registerEvent(PlayerClaimsCountedEvent.class, (e) -> {
      Player p = e.player;

      if (e.numClaims >= 50) {
        incrementProgression(p);
      }
    });
  }
}