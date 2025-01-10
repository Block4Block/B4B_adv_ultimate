package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;

public class b4b_placeskeletonspawner extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_placeskeletonspawner");


  public b4b_placeskeletonspawner(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.SKELETON_SKULL, "Stone Fabricator", AdvancementFrameType.TASK, true, true, 5f, 9f, "Set up a stone generator by placing a skeleton spawner."), parent, 1);
    registerEvent(BlockPlaceEvent.class, (event) -> {
      Player player = event.getPlayer();
      Block placedBlock = event.getBlockPlaced();

      // Check if the player placed a Skeleton Spawner
      if (placedBlock.getType() == Material.SPAWNER) {
        BlockData blockData = placedBlock.getBlockData();
        if (blockData.getAsString().contains("Skeleton")) {
          // Increment advancement progression
          incrementProgression(player);
        }
      }
    });
  }
}