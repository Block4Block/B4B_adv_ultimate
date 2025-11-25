package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import hasjamon.block4block.events.B4BlockBreakWithinGracePeriodEvent;

public class B4b_breakwithingraceperiod extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_breakwithingraceperiod");


  public B4b_breakwithingraceperiod(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.CLOCK, "A Gracious Period", AdvancementFrameType.TASK, true, true, 1f, 2f , "Break a newly placed block within the grace period to avoid spending a block. (default: 5 sec.)"), parent, 1);

    registerEvent(B4BlockBreakWithinGracePeriodEvent.class, (e) -> {
      Player p = e.player;

      // Only grant if the block would normally require spending a block
      if (e.normallyRequiresBlock) {
        incrementProgression(p);
      }
    });
  }
}