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

public class B4b_pickuprarespawnegg extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_pickuprarespawnegg");

  private static final Set<Material> SPAWN_EGGS = new HashSet<>(Arrays.asList(
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

  public B4b_pickuprarespawnegg(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.WANDERING_TRADER_SPAWN_EGG, "Eggcellent!", AdvancementFrameType.TASK, true, true, 4f, 14f, "Pick up a rare spawn egg laid by a chicken."), parent, 1);

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