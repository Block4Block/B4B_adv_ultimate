package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_intruderalert extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_intruderalert");


  public B4b_intruderalert(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.MUSIC_DISC_STRAD, "(DISABLED)Intruder Alert", AdvancementFrameType.TASK, true, true, 6f, 7f, "Be alerted of an intruder in one of your claims."), parent, 1);
  }
}