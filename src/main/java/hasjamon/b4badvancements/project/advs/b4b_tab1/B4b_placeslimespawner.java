package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class B4b_placeslimespawner extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_placeslimespawner");


  public B4b_placeslimespawner(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.SLIME_BLOCK, "Cubical Conversion Therapy", AdvancementFrameType.TASK, true, true, 7f, 4f , "Turn a Magma Cube Spawner into a Slime Spawner by placing it in The Overworld."), parent, 1);

    registerEvent(BlockPlaceEvent.class, (e) -> {
      Player p = e.getPlayer();
      Block block = e.getBlockPlaced();
      ItemStack itemInHand = e.getItemInHand();

      // Check if a spawner was placed in the Overworld
      if (block.getType() == Material.SPAWNER &&
              block.getWorld().getEnvironment() == World.Environment.NORMAL &&
              itemInHand != null && itemInHand.hasItemMeta()) {

        ItemMeta meta = itemInHand.getItemMeta();
        NamespacedKey spawnTypeKey = new NamespacedKey(org.bukkit.Bukkit.getPluginManager().getPlugin("Block4Block"), "spawnType");

        // Check if the item's persistent data says it was a MAGMA_CUBE spawner
        if (meta.getPersistentDataContainer().has(spawnTypeKey, PersistentDataType.STRING)) {
          String originalType = meta.getPersistentDataContainer().get(spawnTypeKey, PersistentDataType.STRING);

          if (originalType != null && originalType.equals(EntityType.MAGMA_CUBE.name())) {
            incrementProgression(p);
          }
        }
      }
    });
  }
}