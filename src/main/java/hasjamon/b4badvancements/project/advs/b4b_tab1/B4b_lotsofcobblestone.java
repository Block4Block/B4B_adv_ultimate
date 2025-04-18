package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_lotsofcobblestone extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_lotsofcobblestone");


  public B4b_lotsofcobblestone(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.DIAMOND_PICKAXE, "(DISABLED)Speedy Stonebreaker", AdvancementFrameType.TASK, true, true, 4f, 10f, "Equip a diamond or netherite pickaxe and have 5 full stacks of cobblestone."), parent, 1);
  }
}