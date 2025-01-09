package hasjamon.b4badvancements.project.advs.b4b_tab2;

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

public class B4b_pickupsugarcane extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_pickupsugarcane");


  public B4b_pickupsugarcane(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.SUGAR_CANE, "Sweet Dreams", AdvancementFrameType.TASK, true, true, 1f, 0f, "Sugar Cane is the first step towards claiming land!"), parent, 1);
    registerEvent(EntityPickupItemEvent.class, (event) -> {
      if (event.getEntity() instanceof Player player) {
        ItemStack item = event.getItem().getItemStack();

        if (item.getType() == Material.SUGAR_CANE) {
          incrementProgression(player);
        }
      }
    });
  }
}