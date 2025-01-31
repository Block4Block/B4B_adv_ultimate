package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_copymasterbookcopy extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_copymasterbookcopy");


  public B4b_copymasterbookcopy(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.ENCHANTED_BOOK, "(DISABLED)I Heard You Like Copies", AdvancementFrameType.TASK, true, true, 7f, 8f, "Create a copy of copy of a Master Book."), parent, 1);
  }
}