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

import java.util.Arrays;
import java.util.List;

public class B4b_killendmobgetenditem extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_killendmobgetenditem");

  private static final List<Material> VALID_ITEMS = Arrays.asList(
          Material.END_STONE,
          Material.END_ROD
  );

  public B4b_killendmobgetenditem(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.END_STONE, "End Game", AdvancementFrameType.TASK, true, true, 3f, 6f, "Obtain end stone or end rods from an End mob."), parent, 1);

    registerEvent(EntityDeathEvent.class, (event) -> {
      if (event.getEntity() instanceof EnderDragon || event.getEntity() instanceof Enderman || event.getEntity() instanceof Endermite) {
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