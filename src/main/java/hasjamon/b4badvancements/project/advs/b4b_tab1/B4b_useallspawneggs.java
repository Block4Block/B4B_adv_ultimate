package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class B4b_useallspawneggs extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_useallspawneggs");

  private static NamespacedKey USED_EGGS_KEY;
  private static NamespacedKey BLACK_BEAR_EGG_KEY; // Key for the custom black bear egg

  // All vanilla spawn egg types (removed BLACK_BEAR_SPAWN_EGG)
  private static final Set<Material> ALL_SPAWN_EGGS = Set.of(
          Material.TROPICAL_FISH_SPAWN_EGG, Material.COW_SPAWN_EGG, Material.SHEEP_SPAWN_EGG,
          Material.PIG_SPAWN_EGG, Material.HORSE_SPAWN_EGG, Material.COD_SPAWN_EGG,
          Material.SALMON_SPAWN_EGG, Material.DONKEY_SPAWN_EGG, Material.RABBIT_SPAWN_EGG,
          Material.GOAT_SPAWN_EGG, Material.WOLF_SPAWN_EGG, Material.BAT_SPAWN_EGG,
          Material.SQUID_SPAWN_EGG, Material.BEE_SPAWN_EGG, Material.PARROT_SPAWN_EGG,
          Material.LLAMA_SPAWN_EGG, Material.CAT_SPAWN_EGG, Material.FOX_SPAWN_EGG,
          Material.MULE_SPAWN_EGG, Material.TURTLE_SPAWN_EGG, Material.PANDA_SPAWN_EGG,
          Material.POLAR_BEAR_SPAWN_EGG, Material.DOLPHIN_SPAWN_EGG, Material.CAMEL_SPAWN_EGG,
          Material.OCELOT_SPAWN_EGG, Material.PUFFERFISH_SPAWN_EGG, Material.TRADER_LLAMA_SPAWN_EGG,
          Material.GLOW_SQUID_SPAWN_EGG, Material.FROG_SPAWN_EGG, Material.TADPOLE_SPAWN_EGG,
          Material.ZOMBIE_SPAWN_EGG, Material.SKELETON_SPAWN_EGG, Material.SPIDER_SPAWN_EGG,
          Material.CAVE_SPIDER_SPAWN_EGG, Material.CREEPER_SPAWN_EGG, Material.DROWNED_SPAWN_EGG,
          Material.HUSK_SPAWN_EGG, Material.BOGGED_SPAWN_EGG, Material.PHANTOM_SPAWN_EGG,
          Material.SILVERFISH_SPAWN_EGG, Material.ENDERMITE_SPAWN_EGG, Material.PILLAGER_SPAWN_EGG,
          Material.ALLAY_SPAWN_EGG, Material.SNOW_GOLEM_SPAWN_EGG, Material.STRIDER_SPAWN_EGG,
          Material.SLIME_SPAWN_EGG, Material.WANDERING_TRADER_SPAWN_EGG, Material.AXOLOTL_SPAWN_EGG,
          Material.COPPER_GOLEM_SPAWN_EGG, Material.ZOMBIFIED_PIGLIN_SPAWN_EGG, Material.VEX_SPAWN_EGG,
          Material.WITCH_SPAWN_EGG, Material.VINDICATOR_SPAWN_EGG, Material.STRAY_SPAWN_EGG,
          Material.GUARDIAN_SPAWN_EGG, Material.ENDERMAN_SPAWN_EGG, Material.PIGLIN_SPAWN_EGG,
          Material.PIGLIN_BRUTE_SPAWN_EGG, Material.ZOGLIN_SPAWN_EGG, Material.HOGLIN_SPAWN_EGG,
          Material.MAGMA_CUBE_SPAWN_EGG, Material.IRON_GOLEM_SPAWN_EGG, Material.BLAZE_SPAWN_EGG,
          Material.BREEZE_SPAWN_EGG, Material.RAVAGER_SPAWN_EGG, Material.WITHER_SKELETON_SPAWN_EGG,
          Material.SHULKER_SPAWN_EGG, Material.EVOKER_SPAWN_EGG, Material.SKELETON_HORSE_SPAWN_EGG,
          Material.VILLAGER_SPAWN_EGG, Material.ZOMBIE_VILLAGER_SPAWN_EGG, Material.MOOSHROOM_SPAWN_EGG,
          Material.ELDER_GUARDIAN_SPAWN_EGG, Material.GHAST_SPAWN_EGG, Material.HAPPY_GHAST_SPAWN_EGG,
          Material.SNIFFER_SPAWN_EGG, Material.WARDEN_SPAWN_EGG, Material.CHICKEN_SPAWN_EGG,
          Material.ZOMBIE_HORSE_SPAWN_EGG
  );

  // Total includes 90 vanilla + 1 custom black bear = 91
  private static final int TOTAL_SPAWN_EGGS = ALL_SPAWN_EGGS.size() + 1;

  public B4b_useallspawneggs(Advancement parent, JavaPlugin plugin) {
    super(KEY.getKey(), new AdvancementDisplay(Material.CHICKEN_SPAWN_EGG, "Egghead Eggstraordinaire", AdvancementFrameType.TASK, true, true, 7f, 14f, "Use each type of spawn egg at least once."), parent, TOTAL_SPAWN_EGGS);

    // Initialize the NamespacedKey for persistent storage
    USED_EGGS_KEY = new NamespacedKey(plugin, "used_spawn_eggs");
    BLACK_BEAR_EGG_KEY = new NamespacedKey(plugin, "black_bear_egg"); // Should match your custom egg key

    registerEvent(PlayerInteractEvent.class, (e) -> {
      Player p = e.getPlayer();
      ItemStack item = e.getItem();

      if (item == null) return;

      Material itemType = item.getType();
      String eggIdentifier = null;

      // Check if it's a vanilla spawn egg
      if (ALL_SPAWN_EGGS.contains(itemType)) {
        eggIdentifier = itemType.name();
      }
      // Check if it's the custom black bear spawn egg
      else if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer().has(BLACK_BEAR_EGG_KEY, PersistentDataType.BYTE)) {
        eggIdentifier = "BLACK_BEAR_SPAWN_EGG";
      }

      // If we identified a spawn egg, track it
      if (eggIdentifier != null) {
        Set<String> playerEggs = getUsedSpawnEggs(p);

        // Only increment if this is a new spawn egg type for the player
        if (!playerEggs.contains(eggIdentifier)) {
          playerEggs.add(eggIdentifier);
          saveUsedSpawnEggs(p, playerEggs);
          incrementProgression(p);
        }
      }
    });
  }

  /**
   * Get the set of spawn eggs the player has used from persistent storage
   */
  private Set<String> getUsedSpawnEggs(Player player) {
    String data = player.getPersistentDataContainer().get(USED_EGGS_KEY, PersistentDataType.STRING);

    if (data == null || data.isEmpty()) {
      return new HashSet<>();
    }

    // Parse the comma-separated list of egg identifiers
    return Arrays.stream(data.split(","))
            .collect(Collectors.toSet());
  }

  /**
   * Save the set of spawn eggs the player has used to persistent storage
   */
  private void saveUsedSpawnEggs(Player player, Set<String> usedEggs) {
    // Convert the set to a comma-separated string
    String data = String.join(",", usedEggs);

    player.getPersistentDataContainer().set(USED_EGGS_KEY, PersistentDataType.STRING, data);
  }
}