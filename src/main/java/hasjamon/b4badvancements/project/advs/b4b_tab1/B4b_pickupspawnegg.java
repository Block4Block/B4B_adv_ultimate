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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class B4b_pickupspawnegg extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_pickupspawnegg");

  private static final Set<Material> SPAWN_EGGS = new HashSet<>(Arrays.asList(
          Material.TROPICAL_FISH_SPAWN_EGG,
          Material.COW_SPAWN_EGG,
          Material.SHEEP_SPAWN_EGG,
          Material.PIG_SPAWN_EGG,
          Material.HORSE_SPAWN_EGG,
          Material.COD_SPAWN_EGG,
          Material.SALMON_SPAWN_EGG,
          Material.DONKEY_SPAWN_EGG,
          Material.RABBIT_SPAWN_EGG,
          Material.GOAT_SPAWN_EGG,
          Material.WOLF_SPAWN_EGG,
          Material.BAT_SPAWN_EGG,
          Material.SQUID_SPAWN_EGG,
          Material.BEE_SPAWN_EGG,
          Material.PARROT_SPAWN_EGG,
          Material.LLAMA_SPAWN_EGG,
          Material.CAT_SPAWN_EGG,
          Material.FOX_SPAWN_EGG,
          Material.MULE_SPAWN_EGG,
          Material.TURTLE_SPAWN_EGG,
          Material.PANDA_SPAWN_EGG,
          Material.POLAR_BEAR_SPAWN_EGG,
          Material.DOLPHIN_SPAWN_EGG,
          Material.CAMEL_SPAWN_EGG,
          Material.OCELOT_SPAWN_EGG,
          Material.PUFFERFISH_SPAWN_EGG,
          Material.TRADER_LLAMA_SPAWN_EGG,
          Material.GLOW_SQUID_SPAWN_EGG,
          Material.FROG_SPAWN_EGG,
          Material.TADPOLE_SPAWN_EGG,
          Material.ZOMBIE_SPAWN_EGG,
          Material.SKELETON_SPAWN_EGG,
          Material.SPIDER_SPAWN_EGG,
          Material.CAVE_SPIDER_SPAWN_EGG,
          Material.CREEPER_SPAWN_EGG,
          Material.DROWNED_SPAWN_EGG,
          Material.HUSK_SPAWN_EGG,
          Material.BOGGED_SPAWN_EGG,
          Material.PHANTOM_SPAWN_EGG,
          Material.SILVERFISH_SPAWN_EGG,
          Material.ENDERMITE_SPAWN_EGG,
          Material.PILLAGER_SPAWN_EGG,
          Material.ALLAY_SPAWN_EGG,
          Material.SNOW_GOLEM_SPAWN_EGG,
          Material.STRIDER_SPAWN_EGG,
          Material.SLIME_SPAWN_EGG,
          Material.WANDERING_TRADER_SPAWN_EGG,
          Material.AXOLOTL_SPAWN_EGG,
          Material.IRON_GOLEM_SPAWN_EGG,
          Material.ZOMBIFIED_PIGLIN_SPAWN_EGG,
          Material.VEX_SPAWN_EGG,
          Material.WITCH_SPAWN_EGG,
          Material.VINDICATOR_SPAWN_EGG,
          Material.STRAY_SPAWN_EGG,
          Material.GUARDIAN_SPAWN_EGG,
          Material.ENDERMAN_SPAWN_EGG,
          Material.PIGLIN_SPAWN_EGG,
          Material.PIGLIN_BRUTE_SPAWN_EGG,
          Material.ZOGLIN_SPAWN_EGG,
          Material.HOGLIN_SPAWN_EGG,
          Material.MAGMA_CUBE_SPAWN_EGG,
          Material.BLAZE_SPAWN_EGG,
          Material.BREEZE_SPAWN_EGG,
          Material.RAVAGER_SPAWN_EGG,
          Material.WITHER_SKELETON_SPAWN_EGG,
          Material.SHULKER_SPAWN_EGG,
          Material.EVOKER_SPAWN_EGG,
          Material.SKELETON_HORSE_SPAWN_EGG,
          Material.VILLAGER_SPAWN_EGG,
          Material.ZOMBIE_VILLAGER_SPAWN_EGG,
          Material.MOOSHROOM_SPAWN_EGG,
          Material.ELDER_GUARDIAN_SPAWN_EGG,
          Material.GHAST_SPAWN_EGG,
          Material.SNIFFER_SPAWN_EGG,
          Material.WARDEN_SPAWN_EGG,
          Material.CHICKEN_SPAWN_EGG,
          Material.ZOMBIE_HORSE_SPAWN_EGG
  ));

  public B4b_pickupspawnegg(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.PIG_SPAWN_EGG, "Egguse me!?", AdvancementFrameType.TASK, true, true, 3f, 12f, "Pick up any spawn egg laid by a chicken."), parent, 1);

    registerEvent(EntityPickupItemEvent.class, (event) -> {
      if (event.getEntity() instanceof Player player) {
        ItemStack item = event.getItem().getItemStack();

        if (SPAWN_EGGS.contains(item.getType())) {
          incrementProgression(player);
        }
      }
    });
  }
}