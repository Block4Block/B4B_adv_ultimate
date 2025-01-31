package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_protectclaimwithgravityblock extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_protectclaimwithgravityblock");


  public B4b_protectclaimwithgravityblock(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.APPLE, "(DISABLED)Newtonian Defense", AdvancementFrameType.TASK, true, true, 7f, 2f, "Place a gravity-affected block on top of a block protecting a Claim Lectern."), parent, 1);
  }
}