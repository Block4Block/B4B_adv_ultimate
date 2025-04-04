package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_removeclaim extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_removeclaim");


  public B4b_removeclaim(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.WARPED_FENCE_GATE, "(DISABLED)Annexation", AdvancementFrameType.TASK, true, true, 7f, 4f, "Steal the claim book or break the lectern of another player's claim."), parent, 1);
  }
}