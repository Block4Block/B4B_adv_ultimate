package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_pickuppumpkin extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_pickuppumpkin");


  public B4b_pickuppumpkin(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.PUMPKIN, "Pumpkin Pusher", AdvancementFrameType.TASK, true, true, 4f, 3f , "Pick up a Pumpkin after indirectly breaking it."), parent, 1);
  }
}