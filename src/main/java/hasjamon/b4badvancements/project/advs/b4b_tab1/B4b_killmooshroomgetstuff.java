package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class B4b_killmooshroomgetstuff extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_killmooshroomgetstuff");

  private static final List<Material> VALID_ITEMS = Arrays.asList(
          Material.CRIMSON_STEM,
          Material.CRIMSON_HYPHAE,
          Material.NETHER_WART_BLOCK,
          Material.CRIMSON_FUNGUS,
          Material.WARPED_STEM,
          Material.WARPED_HYPHAE,
          Material.WARPED_WART_BLOCK,
          Material.BROWN_MUSHROOM_BLOCK,
          Material.RED_MUSHROOM_BLOCK,
          Material.MUSHROOM_STEM,
          Material.BROWN_MUSHROOM,
          Material.RED_MUSHROOM,
          Material.MYCELIUM
  );

  public B4b_killmooshroomgetstuff(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.RED_MUSHROOM, "35 to 42 Days", AdvancementFrameType.TASK, true, true, 4f, 1f , "Obtain mushrooms from a Mooshroom."), parent, 1);

    registerEvent(EntityDeathEvent.class, (event) -> {
      if (event.getEntity() instanceof MushroomCow) {
        Player killer = event.getEntity().getKiller();
        if (killer != null) {
          for (ItemStack item : event.getDrops()) {
            if (VALID_ITEMS.contains(item.getType())) {
              incrementProgression(killer);
              break;
            }
          }
        }
      }
    });
  }
}