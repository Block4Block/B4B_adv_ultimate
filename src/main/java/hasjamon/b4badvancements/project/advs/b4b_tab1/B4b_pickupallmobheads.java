package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_pickupallmobheads extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_pickupallmobheads");


  public B4b_pickupallmobheads(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.DRAGON_HEAD, "Mob Master", AdvancementFrameType.TASK, true, true, 5f, 8f, "Obtain all mob heads by yourself; trade, theft, etc. don't count."), parent, 1);
  }
}