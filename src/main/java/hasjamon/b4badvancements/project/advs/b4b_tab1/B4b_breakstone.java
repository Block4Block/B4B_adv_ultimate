package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import java.util.HashMap;
import java.util.UUID;

public class B4b_breakstone extends BaseAdvancement  {

  // Temporary map to track players and their hotbar state when breaking stone
  private final HashMap<UUID, Boolean> hotbarStoneMap = new HashMap<>();

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_breakstone");


  public B4b_breakstone(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.STONE_PICKAXE, "Stonebreaker", AdvancementFrameType.TASK, true, true, 3f, 9f, "Successfully break stone by spending a stone block from your hotbar."), parent, 1);

    // Track the hotbar state when breaking begins
    registerEvent(PlayerInteractEvent.class, (e) -> {
      if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
        if (e.getClickedBlock() != null && e.getClickedBlock().getType() == Material.STONE) {
          Player p = e.getPlayer();
          UUID playerUUID = p.getUniqueId();

          // Check if there is stone in the hotbar
          boolean hasStoneInHotbar = false;
          for (int i = 0; i < 9; i++) {
            if (p.getInventory().getItem(i) != null && p.getInventory().getItem(i).getType() == Material.STONE) {
              hasStoneInHotbar = true;
              break;
            }
          }

          // Store the hotbar state for this player
          hotbarStoneMap.put(playerUUID, hasStoneInHotbar);
        }
      }
    });

    // Confirm block is broken and grant the advancement if conditions are met
    registerEvent(BlockBreakEvent.class, (e) -> {
      Player p = e.getPlayer();
      UUID playerUUID = p.getUniqueId();

      // Check if the player was tracked as breaking stone
      if (hotbarStoneMap.containsKey(playerUUID)) {
        boolean hadStoneInHotbar = hotbarStoneMap.get(playerUUID); // Retrieve the captured hotbar state
        hotbarStoneMap.remove(playerUUID); // Clean up tracking

        if (hadStoneInHotbar) {
          incrementProgression(p); // Grant the advancement
        }
      }
    });
  }
}