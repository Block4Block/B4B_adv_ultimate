package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class B4b_lotsofcobblestone extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_lotsofcobblestone");


  public B4b_lotsofcobblestone(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.DIAMOND_PICKAXE, "Speedy Stonebreaker", AdvancementFrameType.TASK, true, true, 4f, 10f, "While mining with a diamond or netherite pickaxe, accumulate 5 full stacks of cobblestone."), parent, 1);

    registerEvent(EntityPickupItemEvent.class, (e) -> {
      if (e.getEntity() instanceof Player) {
        Player p = (Player) e.getEntity();

        // Check if picking up cobblestone
        if (e.getItem().getItemStack().getType() == Material.COBBLESTONE) {
          // Schedule check for next tick (after item is added to inventory)
          org.bukkit.Bukkit.getScheduler().runTaskLater(
                  org.bukkit.Bukkit.getPluginManager().getPlugin("Block4Block"),
                  () -> {
                    if (hasRequirements(p)) {
                      incrementProgression(p);
                    }
                  },
                  1L
          );
        }
      }
    });
  }

  private boolean hasRequirements(Player p) {
    PlayerInventory inv = p.getInventory();

    // Check for diamond or netherite pickaxe in hand
    ItemStack mainHand = inv.getItemInMainHand();
    ItemStack offHand = inv.getItemInOffHand();
    boolean hasPickaxe = mainHand.getType() == Material.DIAMOND_PICKAXE ||
            mainHand.getType() == Material.NETHERITE_PICKAXE ||
            offHand.getType() == Material.DIAMOND_PICKAXE ||
            offHand.getType() == Material.NETHERITE_PICKAXE;

    if (!hasPickaxe) return false;

    // Count cobblestone in inventory
    int cobblestoneCount = 0;
    for (ItemStack item : inv.getContents()) {
      if (item != null && item.getType() == Material.COBBLESTONE) {
        cobblestoneCount += item.getAmount();
      }
    }

    // Need 5 full stacks (320 cobblestone)
    return cobblestoneCount >= 320;
  }
}