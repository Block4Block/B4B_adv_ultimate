package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_fishgetrarestuff extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_fishgetrarestuff");


  public B4b_fishgetrarestuff(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.NAUTILUS_SHELL, "Exotic Fishing", AdvancementFrameType.TASK, true, true, 4f, 0f , "Catch a rare fishing reward."), parent, 1);
  }
}