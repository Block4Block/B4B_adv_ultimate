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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.block.Action;
import org.bukkit.Bukkit;
import hasjamon.block4block.Block4Block;
import hasjamon.block4block.utils.utils;

public class B4b_buildirongolem extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_buildirongolem");

  public B4b_buildirongolem(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.JACK_O_LANTERN, "Iron Dome", AdvancementFrameType.TASK, true, true, 8f, 2f, "Build an iron golem to defend your claim against anyone who isn't on the list."), parent, 1);

    // Handle placing carved pumpkin or jack o'lantern
    registerEvent(BlockPlaceEvent.class, (e) -> {
      Player p = e.getPlayer();

      // Check if the placed block is a carved pumpkin or jack o'lantern (the head that completes the golem)
      if (e.getBlock().getType() != Material.CARVED_PUMPKIN &&
              e.getBlock().getType() != Material.JACK_O_LANTERN) {
        return;
      }

      checkAndGrantAdvancement(p, e.getBlock().getLocation());
    });

    // Handle carving a pumpkin with shears
    registerEvent(PlayerInteractEvent.class, (e) -> {
      if (e.getAction() != Action.RIGHT_CLICK_BLOCK || e.getClickedBlock() == null) {
        return;
      }

      Player p = e.getPlayer();

      // Check if player is using shears on a pumpkin
      if (e.getItem() == null || e.getItem().getType() != Material.SHEARS) {
        return;
      }

      if (e.getClickedBlock().getType() != Material.PUMPKIN) {
        return;
      }

      checkAndGrantAdvancement(p, e.getClickedBlock().getLocation());
    });
  }

  private void checkAndGrantAdvancement(Player p, org.bukkit.Location location) {
    // Get Block4Block plugin instance
    Block4Block b4bPlugin = (Block4Block) Bukkit.getPluginManager().getPlugin("Block4Block");
    if (b4bPlugin == null) {
      return;
    }

    // Check if the block is inside a claim
    String claimID = utils.getClaimID(location);
    if (!b4bPlugin.cfg.getClaimData().contains(claimID)) {
      return;
    }

    // Check if the player is a member of the claim
    String[] members = utils.getMembers(location);
    if (members != null && utils.isMemberOfClaim(members, p)) {
      incrementProgression(p);
    }
  }
}