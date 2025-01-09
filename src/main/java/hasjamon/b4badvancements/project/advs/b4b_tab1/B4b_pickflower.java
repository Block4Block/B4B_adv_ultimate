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

public class B4b_pickflower extends BaseAdvancement {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_pickflower");

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

  public B4b_pickflower(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.POPPY, "Watering Flowers", AdvancementFrameType.TASK, true, true, 2f, 0f, "Pick up a flower. (Use a water bucket to break flowers)"), parent, 1);
    registerEvent(EntityPickupItemEvent.class, (event) -> {
      if (event.getEntity() instanceof Player player) {
        ItemStack item = event.getItem().getItemStack();

        if (FLOWERS.contains(item.getType())) {
          incrementProgression(player);
        }
      }
    });
  }
}
