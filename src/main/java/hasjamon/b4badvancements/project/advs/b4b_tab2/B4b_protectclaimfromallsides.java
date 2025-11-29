package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import hasjamon.block4block.utils.utils;
import hasjamon.block4block.Block4Block;
import org.bukkit.Bukkit;

public class B4b_protectclaimfromallsides extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_protectclaimfromallsides");

  private static Block4Block b4bPlugin;

  public B4b_protectclaimfromallsides(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.COMPASS, "Cardinal Point Defense", AdvancementFrameType.TASK, true, true, 6f, 2f, "Protect a Claim Lectern from all 4 directions."), parent, 1);

    // Get the Block4Block plugin instance
    if (b4bPlugin == null) {
      b4bPlugin = (Block4Block) Bukkit.getPluginManager().getPlugin("Block4Block");
    }

    registerEvent(BlockPlaceEvent.class, (e) -> {
      Player p = e.getPlayer();
      Block placedBlock = e.getBlockPlaced();

      // Check if the placed block is adjacent to a claim block
      if (utils.isAdjacentToClaimBlock(placedBlock)) {
        // Find the adjacent claim block
        for (BlockFace face : b4bPlugin.cfg.getProtectiveBlockFaces()) {
          Block adjacent = placedBlock.getRelative(face);
          if (utils.isClaimBlock(adjacent)) {
            // Check if this claim block is now protected from all 4 sides
            long protectedSides = utils.countProtectedSides(adjacent);
            if (protectedSides == 4) {
              incrementProgression(p);
              return; // Grant advancement once and exit
            }
          }
        }
      }
    });
  }
}