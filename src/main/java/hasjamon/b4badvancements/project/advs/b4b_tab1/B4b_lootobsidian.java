package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_lootobsidian extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_lootobsidian");


  public B4b_lootobsidian(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.OBSIDIAN, "Obsidian Obtainer", AdvancementFrameType.TASK, true, true, 6f, 9f, "Grab Obsidian from a chest. (Can be found near unfinished portals)"), parent, 1);
  }
}