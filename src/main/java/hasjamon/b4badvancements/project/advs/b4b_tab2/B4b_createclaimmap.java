package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_createclaimmap extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_createclaimmap");


  public B4b_createclaimmap(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.FILLED_MAP, "(DISABLED)Borderline Mapping", AdvancementFrameType.TASK, true, true, 6f, 5f, "Use a map on a lectern to create a claim map."), parent, 1);
  }
}