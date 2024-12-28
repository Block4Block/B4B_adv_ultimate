package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_protectclaimfromallsides extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_protectclaimfromallsides");


  public B4b_protectclaimfromallsides(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.COMPASS, "Cardinal Point Defense", AdvancementFrameType.TASK, true, true, 6f, 2f, "Protect a Claim Lectern from all \" + numProtectiveBlockFaces + \" directions."), parent, 1);
  }
}