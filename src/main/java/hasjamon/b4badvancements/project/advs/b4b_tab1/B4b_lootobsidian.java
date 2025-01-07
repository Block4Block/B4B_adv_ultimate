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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;

public class B4b_lootobsidian extends BaseAdvancement {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_lootobsidian");

  public B4b_lootobsidian(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.OBSIDIAN, "Obsidian Obtainer", AdvancementFrameType.TASK, true, true, 6f, 9f, "Find Obsidian in a chest."), parent, 1);

    registerEvent(PlayerInteractEvent.class, (event) -> {
      if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock() != null && event.getClickedBlock().getType() == Material.CHEST) {
        Chest chest = (Chest) event.getClickedBlock().getState();
        Inventory inventory = chest.getInventory();
        Player player = event.getPlayer();

        if (inventory.contains(Material.OBSIDIAN)) {
          incrementProgression(player);
        }
      }
    });
  }
}
