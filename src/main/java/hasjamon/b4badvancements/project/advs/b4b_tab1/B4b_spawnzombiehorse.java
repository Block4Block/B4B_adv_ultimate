package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_spawnzombiehorse extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_spawnzombiehorse");


  public B4b_spawnzombiehorse(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.CREEPER_SPAWN_EGG, "(DISABLED)Zemgg", AdvancementFrameType.TASK, true, true, 6f, 14f, "Spawn a Zombie Horse."), parent, 1);
  }
}