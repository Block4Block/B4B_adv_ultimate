package hasjamon.b4badvancements.project.advs.b4b_tab1;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.block.Block;

public class B4b_hitdripstonewithtrident extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_hitdripstonewithtrident");


  public B4b_hitdripstonewithtrident(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.POINTED_DRIPSTONE, "Pointy Trident", AdvancementFrameType.TASK, true, true, 4f, 12f, "You broke pointed dripstone with a thrown trident. Nice!"), parent, 1);

    registerEvent(ProjectileHitEvent.class, (e) -> {
      // Check if the projectile is a trident
      if (e.getEntity() instanceof Trident) {
        Trident trident = (Trident) e.getEntity();

        // Check if the trident was thrown by a player
        if (trident.getShooter() instanceof Player) {
          Player p = (Player) trident.getShooter();

          // Check if the trident hit a block
          Block hitBlock = e.getHitBlock();
          if (hitBlock != null && hitBlock.getType() == Material.POINTED_DRIPSTONE) {
            incrementProgression(p);
          }
        }
      }
    });
  }
}