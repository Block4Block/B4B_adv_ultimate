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

public class B4b_protectclaimwithgravityblock extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_protectclaimwithgravityblock");

  private static Block4Block b4bPlugin;

  public B4b_protectclaimwithgravityblock(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.APPLE, "Newtonian Defense", AdvancementFrameType.TASK, true, true, 7f, 2f, "Place a gravity-affected block on top of a block protecting a Claim Lectern."), parent, 1);

    // Get the Block4Block plugin instance
    if (b4bPlugin == null) {
      b4bPlugin = (Block4Block) Bukkit.getPluginManager().getPlugin("Block4Block");
    }

    registerEvent(BlockPlaceEvent.class, (e) -> {
      Player p = e.getPlayer();
      Block placedBlock = e.getBlockPlaced();

      // Check if the placed block has gravity
      if (!placedBlock.getType().hasGravity()) {
        return;
      }

      // Get the block directly below the placed gravity block
      Block blockBelow = placedBlock.getRelative(BlockFace.DOWN);

      // Check if the block below is adjacent to a claim block in a cardinal direction
      for (BlockFace face : b4bPlugin.cfg.getProtectiveBlockFaces()) {
        Block adjacent = blockBelow.getRelative(face);
        if (utils.isClaimBlock(adjacent)) {
          // Verify the block below is actually contributing to protection
          // by checking if removing it would decrease protection count
          long currentProtection = utils.countProtectedSides(adjacent);

          if (currentProtection > 0) {
            // The block below is protecting the lectern, advancement earned!
            incrementProgression(p);
            return;
          }
        }
      }
    });
  }
}