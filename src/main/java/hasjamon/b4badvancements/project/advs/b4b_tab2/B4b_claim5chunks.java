package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import hasjamon.block4block.events.PlayerClaimsCountedEvent;

public class B4b_claim5chunks extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_claim5chunks");


  public B4b_claim5chunks(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.BIRCH_PLANKS, "House Owner", AdvancementFrameType.TASK, true, true, 6f, 6f, "Own 5 claims."), parent, 1);

    registerEvent(PlayerClaimsCountedEvent.class, (e) -> {
      Player p = e.player;

      // Grant advancement if player is a member of 5 or more claims
      if (e.numClaims >= 5) {
        incrementProgression(p);
      }
    });
  }
}