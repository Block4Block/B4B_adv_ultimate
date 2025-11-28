package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import hasjamon.block4block.events.ClaimBookPlacedEvent;

public class B4b_claimchunk extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_claimchunk");


  public B4b_claimchunk(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.LECTERN, "Lectern's Claim List", AdvancementFrameType.TASK, true, true, 5f, 0f, "Create a claim by placing a claim book on a lectern."), parent, 1);

    registerEvent(ClaimBookPlacedEvent.class, (e) -> {
      Player p = e.player;

      // Grant advancement when player places a claim book in a lectern, and they're a member
      if (e.isMember) {
        incrementProgression(p);
      }
    });
  }
}