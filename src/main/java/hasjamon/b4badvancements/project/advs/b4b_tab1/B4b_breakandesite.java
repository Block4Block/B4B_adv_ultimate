package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

public class B4b_breakandesite extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_breakandesite");


  public B4b_breakandesite(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.ANDESITE, "And The Side", AdvancementFrameType.TASK, true, true, 5f, 5f , "Surrounding Andesite blocks fracture when breaking Andesite."), parent, 1);
    registerEvent(BlockBreakEvent.class, (e)-> {
      Player p = e.getPlayer();
      if (e.getBlock().getType()== Material.ANDESITE) {

        incrementProgression(p);
      }
    });
  }
}