package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SpawnEggMeta;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class B4b_spawnzombiehorse extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_spawnzombiehorse");


  public B4b_spawnzombiehorse(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.ZOMBIE_HORSE_SPAWN_EGG, "Zemgg", AdvancementFrameType.TASK, true, true, 6f, 14f, "Spawn a Zombie Horse."), parent, 1);

    registerEvent(PlayerInteractEvent.class, (e) -> {
      Player p = e.getPlayer();
      ItemStack item = e.getItem();

      // Check if player is using a zombie horse spawn egg
      if (item != null && item.getType() == Material.ZOMBIE_HORSE_SPAWN_EGG) {
        incrementProgression(p);
      }
    });
  }
}