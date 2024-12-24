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
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class B4b_breaklogsfreely extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_breaklogsfreely");


  public B4b_breaklogsfreely(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.OAK_LOG, "Got to Break Tree", AdvancementFrameType.TASK, true, true, 1f, 0f , "Logs are free to break! You better try every block."), parent, 1);
  registerEvent(BlockBreakEvent.class, (e)-> {
    Player p = e.getPlayer();
    Set<Material> logTypes = Set.of(Material.OAK_LOG, Material.BIRCH_LOG, Material.SPRUCE_LOG, Material.JUNGLE_LOG, Material.ACACIA_LOG, Material.DARK_OAK_LOG, Material.MANGROVE_LOG, Material.CHERRY_LOG);
    if (logTypes.contains(e.getBlock().getType())) {

          incrementProgression(p);
          }
  });

  }

}