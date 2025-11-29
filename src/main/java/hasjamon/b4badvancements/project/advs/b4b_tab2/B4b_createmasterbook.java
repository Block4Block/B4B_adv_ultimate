package hasjamon.b4badvancements.project.advs.b4b_tab2;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;

public class B4b_createmasterbook extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab2_NAMESPACE, "b4b_createmasterbook");


  public B4b_createmasterbook(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.ENCHANTED_BOOK, "Master Book", AdvancementFrameType.TASK, true, true, 5f, 1f, "Sign your Claim Book to create a Master Book that updates its copies automatically."), parent, 1);

    registerEvent(PlayerEditBookEvent.class, (e) -> {
      Player p = e.getPlayer();

      // Only trigger when the book is being signed
      if (!e.isSigning()) {
        return;
      }

      BookMeta newMeta = e.getNewBookMeta();

      if (newMeta.hasLore()) {
        for (String line : newMeta.getLore()) {
          // Strip color codes before checking
          String strippedLine = line.replaceAll("§[0-9a-fk-or]", "");

          if (strippedLine.contains("Master Book") && strippedLine.contains("#")) {
            incrementProgression(p);
            return;
          }
        }
      }
    });
  }
}