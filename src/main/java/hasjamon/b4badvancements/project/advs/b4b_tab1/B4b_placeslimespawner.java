package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_placeslimespawner extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_placeslimespawner");


  public B4b_placeslimespawner(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.SLIME_BLOCK, "(DISABLED)Cubical Conversion Therapy", AdvancementFrameType.TASK, true, true, 7f, 4f , "Turn a Magma Cube Spawner into a Slime Spawner by placing it in The Overworld."), parent, 1);
  }
}