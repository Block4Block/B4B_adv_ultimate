package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class B4b_killpiggetdirt extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_killpiggetdirt");


  public B4b_killpiggetdirt(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.DIRT, "Dirty Pigs", AdvancementFrameType.TASK, true, true, 1f, 3f , "Obtain dirt from a Pig."), parent, 1);

    registerEvent(EntityDeathEvent.class, (event) -> {
      if (event.getEntity() instanceof Pig) {
        Player killer = event.getEntity().getKiller();
        if (killer != null) {
          for (ItemStack item : event.getDrops()) {
            if (item.getType() == Material.DIRT) {
              incrementProgression(killer);
              break;
            }
          }
        }
      }
    });
  }
}