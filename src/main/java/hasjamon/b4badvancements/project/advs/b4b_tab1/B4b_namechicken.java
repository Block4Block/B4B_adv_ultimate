package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import hasjamon.b4badvancements.project.B4BAdvancements;

public class B4b_namechicken extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_namechicken");


  public B4b_namechicken(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.NAME_TAG, "Chicken Little", AdvancementFrameType.TASK, true, true, 4f, 13f, "Name a chicken to buff nearby chickens' chance to lay Spawn Eggs."), parent, 1);
    registerEvent(PlayerInteractEntityEvent.class, (event) -> {
      Player player = event.getPlayer();
      Entity clickedEntity = event.getRightClicked();

      // Check if the player is interacting with a chicken and has a name tag in hand
      if (clickedEntity instanceof Chicken && player.getInventory().getItemInMainHand().getType() == Material.NAME_TAG) {
        Chicken chicken = (Chicken) clickedEntity;

        // Check if the chicken was previously unnamed
        if (chicken.getCustomName() == null || chicken.getCustomName().isEmpty()) {
          // Delay execution slightly to allow the name to be set
          B4BAdvancements plugin = B4BAdvancements.getInstance(); // Replace with actual instance getter
          player.getServer().getScheduler().runTaskLater(plugin, () -> {
            if (chicken.getCustomName() != null && !chicken.getCustomName().isEmpty()) {
              incrementProgression(player);
            }
          }, 1L); // 1 tick delay
        }
      }
    });
  }
}