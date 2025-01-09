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

public class B4b_pickupmelonslice extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_pickupmelonslice");


  public B4b_pickupmelonslice(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.MELON, "Whack a Melon", AdvancementFrameType.TASK, true, true, 3f, 3f , "Pick up a Melon Slice after indirectly breaking a Melon."), parent, 1);
    registerEvent(EntityPickupItemEvent.class, (event) -> {
      if (event.getEntity() instanceof Player player) {
        ItemStack item = event.getItem().getItemStack();

        if (item.getType() == Material.MELON_SLICE) {
          incrementProgression(player);
        }
      }
    });
  }
}