package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import org.bukkit.Material;

public class B4b_claim10chunks extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_claim10chunks");


  public B4b_claim10chunks(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.BIRCH_PLANKS, "Landlord", AdvancementFrameType.TASK, true, true, 6f, 6f, "Own 10 claims."), parent, 1);
  }
}