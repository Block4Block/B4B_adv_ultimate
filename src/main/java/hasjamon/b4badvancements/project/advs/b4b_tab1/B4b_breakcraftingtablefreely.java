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

import java.util.Set;

public class B4b_breakcraftingtablefreely extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_breakcraftingtablefreely");


  public B4b_breakcraftingtablefreely(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.CRAFTING_TABLE, "MyCraft: Pocket Edition", AdvancementFrameType.TASK, true, true, 3f, 4f , "Crafting on the go."), parent, 1);
    registerEvent(BlockBreakEvent.class, (e)-> {
      Player p = e.getPlayer();
      if (e.getBlock().getType()== Material.CRAFTING_TABLE) {

        incrementProgression(p);
      }
    });
  }
}