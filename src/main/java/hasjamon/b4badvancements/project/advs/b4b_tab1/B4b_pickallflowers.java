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
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class B4b_pickallflowers extends BaseAdvancement {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_pickallflowers");

  private static final Set<Material> FLOWERS = new HashSet<>(Arrays.asList(
          Material.DANDELION,
          Material.POPPY,
          Material.BLUE_ORCHID,
          Material.ALLIUM,
          Material.AZURE_BLUET,
          Material.RED_TULIP,
          Material.ORANGE_TULIP,
          Material.WHITE_TULIP,
          Material.PINK_TULIP,
          Material.OXEYE_DAISY,
          Material.CORNFLOWER,
          Material.LILY_OF_THE_VALLEY,
          Material.WITHER_ROSE
  ));

  public B4b_pickallflowers(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.ROSE_BUSH, "Mother's Day Bouquet", AdvancementFrameType.TASK, true, true, 3f, 2f, "Pick up one of each flower. (Use a water bucket to break flowers)"), parent, FLOWERS.size());
    registerEvent(EntityPickupItemEvent.class, (event) -> {
      if (event.getEntity() instanceof Player player) {
        ItemStack item = event.getItem().getItemStack();

        if (FLOWERS.contains(item.getType())) {
          var dataContainer = player.getPersistentDataContainer();
          String flowerKey = "flower_" + item.getType().name().toLowerCase(); // Convert to lowercase

          // Check if the flower has already been picked up
          if (!dataContainer.has(new NamespacedKey("b4badvancements", flowerKey), PersistentDataType.INTEGER)) {
            // Mark the flower as collected
            dataContainer.set(new NamespacedKey("b4badvancements", flowerKey), PersistentDataType.INTEGER, 1);

            // Increment progression
            incrementProgression(player);

            // Check if all flower types have been collected (at least once for each type)
            boolean allFlowersCollected = true;
            for (Material flower : FLOWERS) {
              String key = "flower_" + flower.name().toLowerCase(); // Convert to lowercase
              if (!dataContainer.has(new NamespacedKey("b4badvancements", key), PersistentDataType.INTEGER)) {
                allFlowersCollected = false;
                break;
              }
            }

            // If all flower types have been collected, complete the advancement
            if (allFlowersCollected) {
              incrementProgression(player);
            }
          }
        }
      }
    });
  }
}
