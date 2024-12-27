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

public class B4b_breakbedfreely extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_breakbedfreely");


  public B4b_breakbedfreely(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.BLUE_BED, "Favourite Bed", AdvancementFrameType.TASK, true, true, 4f, 4f , "I'm not getting a new one! I've finally gotten used to the mattress."), parent, 1);
    registerEvent(BlockBreakEvent.class, (e)-> {
      Player p = e.getPlayer();
      Set<Material> bedTypes = Set.of(Material.BLUE_BED, Material.BLACK_BED, Material.BROWN_BED, Material.LIGHT_BLUE_BED, Material.CYAN_BED, Material.GRAY_BED, Material.GREEN_BED, Material.LIGHT_GRAY_BED, Material.LIME_BED, Material.MAGENTA_BED, Material.ORANGE_BED, Material.PINK_BED, Material.PURPLE_BED, Material.RED_BED, Material.WHITE_BED, Material.YELLOW_BED);
      if (bedTypes.contains(e.getBlock().getType())) {

        incrementProgression(p);
      }
    });
  }
}