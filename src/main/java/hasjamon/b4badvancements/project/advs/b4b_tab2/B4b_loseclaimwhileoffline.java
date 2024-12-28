package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_loseclaimwhileoffline extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_loseclaimwhileoffline");


  public B4b_loseclaimwhileoffline(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.MOJANG_BANNER_PATTERN, "Claim Down!", AdvancementFrameType.TASK, true, true, 6f, 3f, "Lose a claim or have your name removed from a master book while offline."), parent, 1);
  }
}