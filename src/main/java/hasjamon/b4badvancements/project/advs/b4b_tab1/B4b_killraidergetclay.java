package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class B4b_killraidergetclay extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_killraidergetclay");


  public B4b_killraidergetclay(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.CLAY, "Clayment", AdvancementFrameType.TASK, true, true, 3f, 10f, "Obtain clay from a Pillager, Ravager, Vindicator, Evoker, or Vex."), parent, 1);

    registerEvent(EntityDeathEvent.class, (event) -> {
      if (event.getEntity() instanceof Pillager || event.getEntity() instanceof Vindicator || event.getEntity() instanceof Ravager || event.getEntity() instanceof Evoker) {
        Player killer = event.getEntity().getKiller();
        if (killer != null) {
          for (ItemStack item : event.getDrops()) {
            if (item.getType() == Material.CLAY) {
              incrementProgression(killer);
              break;
            }
          }
        }
      }
    });
  }
}