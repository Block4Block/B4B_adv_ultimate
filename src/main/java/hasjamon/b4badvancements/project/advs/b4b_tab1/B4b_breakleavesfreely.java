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

public class B4b_breakleavesfreely extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_breakleavesfreely");


  public B4b_breakleavesfreely(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.OAK_LEAVES, "Leaf Me Alone", AdvancementFrameType.TASK, true, true, 2f, 1f , "Leaves are free to break! You better try every block."), parent, 1);
    registerEvent(BlockBreakEvent.class, (e)-> {
      Player p = e.getPlayer();
      Set<Material> leafTypes = Set.of(Material.OAK_LEAVES, Material.BIRCH_LEAVES, Material.SPRUCE_LEAVES, Material.JUNGLE_LEAVES, Material.ACACIA_LEAVES, Material.DARK_OAK_LEAVES, Material.MANGROVE_LEAVES, Material.CHERRY_LEAVES);
      if (leafTypes.contains(e.getBlock().getType())) {

        incrementProgression(p);
      }
    });
  }
}