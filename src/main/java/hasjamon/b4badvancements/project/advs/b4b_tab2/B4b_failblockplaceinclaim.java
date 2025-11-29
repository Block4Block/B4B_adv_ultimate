package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import hasjamon.block4block.events.BlockPlaceInClaimEvent;

public class B4b_failblockplaceinclaim extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_failblockplaceinclaim");


  public B4b_failblockplaceinclaim(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.WARPED_SIGN, "Access Denied", AdvancementFrameType.TASK, true, true, 6f, 4f, "Attempt to place a block inside a claim you're intruding on."), parent, 1);

    registerEvent(BlockPlaceInClaimEvent.class, (e) -> {
      Player p = e.player;

      // Only grant if the placement failed (not their claim)
      if (!e.success) {
        incrementProgression(p);
      }
    });
  }
}