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

public class B4b_pickupsuperrarespawnegg extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_pickupsuperrarespawnegg");

  private static final Set<Material> SPAWN_EGGS = new HashSet<>(Arrays.asList(
          Material.MOOSHROOM_SPAWN_EGG,
          Material.ELDER_GUARDIAN_SPAWN_EGG,
          Material.GHAST_SPAWN_EGG,
          Material.SNIFFER_SPAWN_EGG,
          Material.WARDEN_SPAWN_EGG,
          Material.CHICKEN_SPAWN_EGG,
          Material.ZOMBIE_HORSE_SPAWN_EGG
  ));

  public B4b_pickupsuperrarespawnegg(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.ELDER_GUARDIAN_SPAWN_EGG, "(UNTESTED)Eggstraordinarily Eggstatic!", AdvancementFrameType.TASK, true, true, 5f, 14f, "Pick up a super rare spawn egg laid by a chicken."), parent, 1);

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