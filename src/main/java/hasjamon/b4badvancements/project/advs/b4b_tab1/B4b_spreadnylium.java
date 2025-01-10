package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class B4b_spreadnylium extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_spreadnylium");


  public B4b_spreadnylium(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.BONE_MEAL, "Spreading Nylium", AdvancementFrameType.TASK, true, true, 6f, 4f , "Apply bone meal to netherrack sitting next to nylium to convert it to nylium."), parent, 1);
    registerEvent(PlayerInteractEvent.class, (event) -> {
      Player player = event.getPlayer();
      Block clickedBlock = event.getClickedBlock();

      // Check if the player used bone meal on a block
      if (clickedBlock != null && event.getItem() != null && event.getItem().getType() == Material.BONE_MEAL) {
        Material blockType = clickedBlock.getType();

        // Check if the block is crimson nylium or warped nylium
        if (blockType == Material.NETHERRACK) {
          // Increment advancement progression
          incrementProgression(player);
        }
      }
    });
  }
}
