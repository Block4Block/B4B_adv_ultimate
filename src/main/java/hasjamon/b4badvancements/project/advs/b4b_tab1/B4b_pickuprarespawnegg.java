package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_pickuprarespawnegg extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_pickuprarespawnegg");


  public B4b_pickuprarespawnegg(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.WANDERING_TRADER_SPAWN_EGG, "(DISABLED)Eggcellent!", AdvancementFrameType.TASK, true, true, 4f, 14f, "Pick up a rare spawn egg laid by a chicken."), parent, 1);
  }
}