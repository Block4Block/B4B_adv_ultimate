package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import hasjamon.block4block.events.BlockBreakInClaimEvent;

public class B4b_breakinclaim extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_breakinclaim");


  public B4b_breakinclaim(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.RED_BANNER, "Reclaimed Rights", AdvancementFrameType.TASK, true, true, 6f, 1f, "Some blocks are free to break, if you have a claim. In this case, you do."), parent, 1);

    registerEvent(BlockBreakInClaimEvent.class, (e) -> {
      Player p = e.player;

      // Only grant if the break was successful (claim-specific free break)
      if (e.success) {
        incrementProgression(p);
      }
    });
  }
}