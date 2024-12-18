package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_pickupvaluablerandomdrop extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_pickupvaluablerandomdrop");


  public B4b_pickupvaluablerandomdrop(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.DIAMOND_BLOCK, "Extraordinary Luck", AdvancementFrameType.TASK, true, true, 6f, 1f , "You found something extraordinary from an unexpected source."), parent, 1);
  }
}