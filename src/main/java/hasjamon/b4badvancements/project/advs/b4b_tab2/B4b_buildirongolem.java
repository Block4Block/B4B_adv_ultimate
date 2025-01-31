package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_buildirongolem extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_buildirongolem");


  public B4b_buildirongolem(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.JACK_O_LANTERN, "(DISABLED)Iron Dome", AdvancementFrameType.TASK, true, true, 8f, 2f, "Build an iron golem to defend your claim against anyone who isn't on the list."), parent, 1);
  }
}