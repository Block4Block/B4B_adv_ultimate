package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_useallspawneggs extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_useallspawneggs");


  public B4b_useallspawneggs(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.CHICKEN_SPAWN_EGG, "Egghead Eggtraordinaire", AdvancementFrameType.TASK, true, true, 7f, 14f, "Use each type of spawn egg at least once."), parent, 1);
  }
}