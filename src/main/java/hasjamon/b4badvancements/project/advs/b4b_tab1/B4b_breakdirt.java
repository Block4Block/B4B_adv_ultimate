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

public class B4b_breakdirt extends BaseAdvancement  {

  // Temporary map to track players and their hotbar state when breaking dirt
  private final HashMap<UUID, Boolean> hotbarDirtMap = new HashMap<>();

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_breakdirt");


  public B4b_breakdirt(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.IRON_SHOVEL, "Dirtbreaker", AdvancementFrameType.TASK, true, true, 2f, 5f , "Successfully break dirt by spending a dirt block from your hotbar."), parent, 1);

    // Track the hotbar state when breaking begins
    registerEvent(PlayerInteractEvent.class, (e) -> {
      if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
        if (e.getClickedBlock() != null && e.getClickedBlock().getType() == Material.DIRT) {
          Player p = e.getPlayer();
          UUID playerUUID = p.getUniqueId();

          // Check if there is dirt in the hotbar
          boolean hasDirtInHotbar = false;
          for (int i = 0; i < 9; i++) {
            if (p.getInventory().getItem(i) != null && p.getInventory().getItem(i).getType() == Material.DIRT) {
              hasDirtInHotbar = true;
              break;
            }
          }

          // Store the hotbar state for this player
          hotbarDirtMap.put(playerUUID, hasDirtInHotbar);
        }
      }
    });

    // Confirm block is broken and grant the advancement if conditions are met
    registerEvent(BlockBreakEvent.class, (e) -> {
      Player p = e.getPlayer();
      UUID playerUUID = p.getUniqueId();

      // Check if the player was tracked as breaking dirt
      if (hotbarDirtMap.containsKey(playerUUID)) {
        boolean hadDirtInHotbar = hotbarDirtMap.get(playerUUID); // Retrieve the captured hotbar state
        hotbarDirtMap.remove(playerUUID); // Clean up tracking

        if (hadDirtInHotbar) {
          incrementProgression(p); // Grant the advancement
        }
      }
    });
  }
}