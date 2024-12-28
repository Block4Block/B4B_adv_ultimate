package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_pickupsugarcane extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_pickupsugarcane");


  public B4b_pickupsugarcane(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.SUGAR_CANE, "Sweet Dreams", AdvancementFrameType.TASK, true, true, 1f, 0f, "Sugar Cane is the first step towards claiming land!"), parent, 1);
  }
}