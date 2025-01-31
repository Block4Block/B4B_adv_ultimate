package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.entity.PolarBear;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class B4b_killpolarbeargetice extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_killpolarbeargetice");


  public B4b_killpolarbeargetice(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.ICE, "Ice Cold Murder", AdvancementFrameType.TASK, true, true, 3f, 1f , "Obtain ice from a Polar Bear."), parent, 1);

    registerEvent(EntityDeathEvent.class, (event) -> {
      if (event.getEntity() instanceof PolarBear) {
        Player killer = event.getEntity().getKiller();
        if (killer != null) {
          for (ItemStack item : event.getDrops()) {
            if (item.getType() == Material.ICE) {
              incrementProgression(killer);
              break;
            }
          }
        }
      }
    });
  }
}