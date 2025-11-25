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
import org.bukkit.event.inventory.CraftItemEvent;

import java.util.Set;

public class B4b_pickcraftalldyes extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.b4b_tab1_NAMESPACE, "b4b_pickcraftalldyes");

  private static final Set<Material> ALL_DYES = Set.of(
          Material.WHITE_DYE,
          Material.LIGHT_GRAY_DYE,
          Material.GRAY_DYE,
          Material.BLACK_DYE,
          Material.BROWN_DYE,
          Material.RED_DYE,
          Material.ORANGE_DYE,
          Material.YELLOW_DYE,
          Material.LIME_DYE,
          Material.GREEN_DYE,
          Material.CYAN_DYE,
          Material.LIGHT_BLUE_DYE,
          Material.BLUE_DYE,
          Material.PURPLE_DYE,
          Material.MAGENTA_DYE,
          Material.PINK_DYE
  );

  public B4b_pickcraftalldyes(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.BROWN_DYE, "Mother's Tears", AdvancementFrameType.TASK, true, true, 4f, 2f , "Craft every craftable dye."), parent, 16);

    // Track when player picks up dyes
    registerEvent(EntityPickupItemEvent.class, (e) -> {
      if (e.getEntity() instanceof Player) {
        Player p = (Player) e.getEntity();
        Material itemType = e.getItem().getItemStack().getType();

        if (ALL_DYES.contains(itemType)) {
          incrementProgression(p);
        }
      }
    });

    // Also track crafting events for completeness
    registerEvent(CraftItemEvent.class, (e) -> {
      if (e.getWhoClicked() instanceof Player) {
        Player p = (Player) e.getWhoClicked();
        Material crafted = e.getRecipe().getResult().getType();

        if (ALL_DYES.contains(crafted)) {
          incrementProgression(p);
        }
      }
    });
  }
}