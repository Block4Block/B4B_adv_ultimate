package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_bedcmd extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_bedcmd");


  public B4b_bedcmd(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.WHITE_BED, "(DISABLED)Emergency Bed", AdvancementFrameType.TASK, true, true, 3f, 13f, "Write '/bed' in Chat for a free bed, available once a day"), parent, 1);
  }
}