package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class B4b_creeperexplodegetgunpowder extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_creeperexplodegetgunpowder");

  private static final String METADATA_KEY = "b4b_creeper_gunpowder";
  private final Set<UUID> trackedGunpowder = new HashSet<>();

  public B4b_creeperexplodegetgunpowder(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.GUNPOWDER, "Creepy Remnants", AdvancementFrameType.TASK, true, true, 3f, 5f, "Pick up gunpowder after a creeper explodes."), parent, 1);

    // Track gunpowder dropped by creeper explosions
    registerEvent(EntityExplodeEvent.class, (e) -> {
      if (e.getEntityType() == EntityType.CREEPER) {
        // Wait a tick for the item to spawn, then tag it
        org.bukkit.Bukkit.getScheduler().runTaskLater(
                org.bukkit.Bukkit.getPluginManager().getPlugin("Block4Block"),
                () -> {
                  e.getLocation().getWorld().getNearbyEntities(e.getLocation(), 2, 2, 2).stream()
                          .filter(entity -> entity instanceof Item)
                          .map(entity -> (Item) entity)
                          .filter(item -> item.getItemStack().getType() == Material.GUNPOWDER)
                          .forEach(item -> trackedGunpowder.add(item.getUniqueId()));
                },
                1L
        );
      }
    });

    // Detect when player picks up tracked gunpowder
    registerEvent(EntityPickupItemEvent.class, (e) -> {
      if (e.getEntity() instanceof Player) {
        Player p = (Player) e.getEntity();
        Item item = e.getItem();

        if (item.getItemStack().getType() == Material.GUNPOWDER &&
                trackedGunpowder.contains(item.getUniqueId())) {
          incrementProgression(p);
          trackedGunpowder.remove(item.getUniqueId());
        }
      }
    });
  }
}