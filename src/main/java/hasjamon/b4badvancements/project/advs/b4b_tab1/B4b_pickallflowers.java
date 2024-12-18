package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_pickallflowers extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_pickallflowers");


  public B4b_pickallflowers(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.ROSE_BUSH, "Mother's Day Bouquet", AdvancementFrameType.TASK, true, true, 3f, 2f , "Pick up one of each flower. (Use a water bucket to break flowers)"), parent, 1);
  }
}