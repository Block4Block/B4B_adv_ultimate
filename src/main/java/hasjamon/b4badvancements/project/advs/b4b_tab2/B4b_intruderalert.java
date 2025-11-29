package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import hasjamon.block4block.events.IntruderEnteredClaimEvent;

public class B4b_intruderalert extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_intruderalert");


  public B4b_intruderalert(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.MUSIC_DISC_STRAD, "Intruder Alert", AdvancementFrameType.TASK, true, true, 6f, 7f, "Be alerted of an intruder in one of your claims."), parent, 1);

    registerEvent(IntruderEnteredClaimEvent.class, (e) -> {
      Player p = e.claimOwner;
      incrementProgression(p);
    });
  }
}