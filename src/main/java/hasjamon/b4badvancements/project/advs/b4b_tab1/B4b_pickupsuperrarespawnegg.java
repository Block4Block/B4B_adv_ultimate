package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_pickupsuperrarespawnegg extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_pickupsuperrarespawnegg");


  public B4b_pickupsuperrarespawnegg(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.ELDER_GUARDIAN_SPAWN_EGG, "b4b_pickupsuperrarespawnegg", AdvancementFrameType.TASK, true, true, 5f, 14f ), parent, 1);
  }
}