package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class B4b_killzombiegetcharcoal extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_killzombiegetcharcoal");


  public B4b_killzombiegetcharcoal(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.CHARCOAL, "Wooden Brain", AdvancementFrameType.TASK, true, true, 1f, 1f, "Obtain Charcoal form a Zombie."), parent, 1);

    registerEvent(EntityDeathEvent.class, (event) -> {
      if (event.getEntity() instanceof Zombie) {
        Player killer = event.getEntity().getKiller();
        if (killer != null) {
          for (ItemStack item : event.getDrops()) {
            if (item.getType() == Material.CHARCOAL) {
              incrementProgression(killer);
              break;
            }
          }
        }
      }
    });
  }
}