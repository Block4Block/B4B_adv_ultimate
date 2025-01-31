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
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class B4b_killwitherskeletongetblackstone extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_killwitherskeletongetblackstone");

  private static final List<Material> VALID_ITEMS = Arrays.asList(
          Material.BLACKSTONE,
          Material.GILDED_BLACKSTONE
  );

  public B4b_killwitherskeletongetblackstone(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.BLACKSTONE, "Withered Stone", AdvancementFrameType.TASK, true, true, 3f, 8f, "Obtain Blackstone from a Wither Skeleton."), parent, 1);

    registerEvent(EntityDeathEvent.class, (event) -> {
      if (event.getEntity() instanceof WitherSkeleton) {
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