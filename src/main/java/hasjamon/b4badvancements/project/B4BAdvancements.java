package hasjamon.b4badvancements.project;

import com.fren_gor.ultimateAdvancementAPI.AdvancementTab;
import com.fren_gor.ultimateAdvancementAPI.UltimateAdvancementAPI;
import com.fren_gor.ultimateAdvancementAPI.advancement.RootAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.events.PlayerLoadingCompletedEvent;
import hasjamon.b4badvancements.project.advs.AdvancementTabNamespaces;
import hasjamon.b4badvancements.project.advs.b4b_tab1.*;
import hasjamon.b4badvancements.project.advs.b4b_tab2.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class B4BAdvancements extends JavaPlugin implements Listener {

    private static B4BAdvancements instance;

    @Override
    public void onEnable() {
        instance = this; // Set the instance when the plugin is enabled
        Bukkit.getPluginManager().registerEvents(this, this);
        initializeTabs();
    }

    public static B4BAdvancements getInstance() {
        return instance; // Provide access to the instance
    }

    public static UltimateAdvancementAPI api;
    public AdvancementTab b4b_tab1;
    public AdvancementTab b4b_tab2;

    public void initializeTabs() {
        api = UltimateAdvancementAPI.getInstance(this);
        b4b_tab1 = api.createAdvancementTab(AdvancementTabNamespaces.b4b_tab1_NAMESPACE);
        b4b_tab2 = api.createAdvancementTab(AdvancementTabNamespaces.b4b_tab2_NAMESPACE);
            RootAdvancement b4b_breakblockfail = new RootAdvancement(b4b_tab1, "b4b_breakblockfail", new AdvancementDisplay(Material.LECTERN, "(DISABLED)A Block for a Block", AdvancementFrameType.TASK, true, true, 0f, 0f , "Some blocks in the world require you to spend a block to break them!"),"textures/block/red_terracotta.png",1);
            B4b_breaklogsfreely b4b_breaklogsfreely = new B4b_breaklogsfreely(b4b_breakblockfail);
            B4b_killzombiegetcharcoal b4b_killzombiegetcharcoal = new B4b_killzombiegetcharcoal(b4b_breakblockfail);
            B4b_breakwithingraceperiod b4b_breakwithingraceperiod = new B4b_breakwithingraceperiod(b4b_breakblockfail);
            B4b_killpiggetdirt b4b_killpiggetdirt = new B4b_killpiggetdirt(b4b_breakblockfail);
            B4b_pickflower b4b_pickflower = new B4b_pickflower(b4b_breaklogsfreely);
            B4b_fishgetspawnegg b4b_fishgetspawnegg = new B4b_fishgetspawnegg(b4b_pickflower);
            B4b_killpolarbeargetice b4b_killpolarbeargetice = new B4b_killpolarbeargetice(b4b_pickflower);
            B4b_pickallflowers b4b_pickallflowers = new B4b_pickallflowers(b4b_pickflower);
            B4b_pickupmelonslice b4b_pickupmelonslice = new B4b_pickupmelonslice(b4b_pickflower);
            B4b_fishgetrarestuff b4b_fishgetrarestuff = new B4b_fishgetrarestuff(b4b_fishgetspawnegg);
            B4b_killmooshroomgetstuff b4b_killmooshroomgetstuff = new B4b_killmooshroomgetstuff(b4b_killpolarbeargetice);
            B4b_killphantomgetelytra b4b_killphantomgetelytra = new B4b_killphantomgetelytra(b4b_killmooshroomgetstuff);
            B4b_pickcraftalldyes b4b_pickcraftalldyes = new B4b_pickcraftalldyes(b4b_pickallflowers);
            B4b_pickuppumpkin b4b_pickuppumpkin = new B4b_pickuppumpkin(b4b_pickupmelonslice);
            B4b_pickupcactus b4b_pickupcactus = new B4b_pickupcactus(b4b_pickuppumpkin);
            B4b_breakleavesfreely b4b_breakleavesfreely = new B4b_breakleavesfreely(b4b_breaklogsfreely);
            B4b_breakcraftingtablefreely b4b_breakcraftingtablefreely = new B4b_breakcraftingtablefreely(b4b_breakleavesfreely);
            B4b_breakbedfreely b4b_breakbedfreely = new B4b_breakbedfreely(b4b_breakcraftingtablefreely);
            B4b_breaknyliumfreely b4b_breaknyliumfreely = new B4b_breaknyliumfreely(b4b_breakbedfreely);
            B4b_spreadnylium b4b_spreadnylium = new B4b_spreadnylium(b4b_breaknyliumfreely);
            B4b_placeslimespawner b4b_placeslimespawner = new B4b_placeslimespawner(b4b_spreadnylium);
            B4b_breakandesite b4b_breakandesite = new B4b_breakandesite(b4b_breakbedfreely);
            B4b_pickupvaluablerandomdrop b4b_pickupvaluablerandomdrop = new B4b_pickupvaluablerandomdrop(b4b_killphantomgetelytra);
            B4b_killcreeperorwitchgetrocket b4b_killcreeperorwitchgetrocket = new B4b_killcreeperorwitchgetrocket(b4b_killzombiegetcharcoal);
            B4b_killskeletongetstone b4b_killskeletongetstone = new B4b_killskeletongetstone(b4b_killzombiegetcharcoal);
            B4b_creeperexplodegetgunpowder b4b_creeperexplodegetgunpowder = new B4b_creeperexplodegetgunpowder(b4b_killcreeperorwitchgetrocket);
            B4b_killendmobgetenditem b4b_killendmobgetenditem = new B4b_killendmobgetenditem(b4b_killskeletongetstone);
            B4b_collectmobhead b4b_collectmobhead = new B4b_collectmobhead(b4b_killskeletongetstone);
            B4b_killwitherskeletongetblackstone b4b_killwitherskeletongetblackstone = new B4b_killwitherskeletongetblackstone(b4b_killskeletongetstone);
            B4b_breakstone b4b_breakstone = new B4b_breakstone(b4b_killskeletongetstone);
            B4b_pickupplayerhead b4b_pickupplayerhead = new B4b_pickupplayerhead(b4b_collectmobhead);
            B4b_collectallmobheads b4b_collectallmobheads = new B4b_collectallmobheads(b4b_collectmobhead);
            B4b_pickupallmobheads b4b_pickupallmobheads = new B4b_pickupallmobheads(b4b_collectallmobheads);
            B4b_disguise b4b_disguise = new B4b_disguise(b4b_pickupplayerhead);
            B4b_pickupspawner b4b_pickupspawner = new B4b_pickupspawner(b4b_breakstone);
            b4b_placeskeletonspawner b4b_placeskeletonspawner = new b4b_placeskeletonspawner(b4b_pickupspawner);
            B4b_lootobsidian b4b_lootobsidian = new B4b_lootobsidian(b4b_placeskeletonspawner);
            B4b_lotsofcobblestone b4b_lotsofcobblestone = new B4b_lotsofcobblestone(b4b_breakstone);
            B4b_smeltcobblestone b4b_smeltcobblestone = new B4b_smeltcobblestone(b4b_breakstone);
            B4b_usenewblastfurnacerecipe b4b_usenewblastfurnacerecipe = new B4b_usenewblastfurnacerecipe(b4b_smeltcobblestone);
            B4b_pickupfallingblock b4b_pickupfallingblock = new B4b_pickupfallingblock(b4b_killpiggetdirt);
            B4b_breakdirt b4b_breakdirt = new B4b_breakdirt(b4b_killpiggetdirt);
            B4b_bedcmd b4b_bedcmd = new B4b_bedcmd(b4b_killpiggetdirt);
            B4b_standcenteroverworld b4b_standcenteroverworld = new B4b_standcenteroverworld(b4b_killpiggetdirt);
            B4b_killendermangetgrass b4b_killendermangetgrass = new B4b_killendermangetgrass(b4b_killpiggetdirt);
            B4b_killraidergetclay b4b_killraidergetclay = new B4b_killraidergetclay(b4b_pickupfallingblock);
            B4b_pickupflint b4b_pickupflint = new B4b_pickupflint(b4b_pickupfallingblock);
            B4b_pickupspawnegg b4b_pickupspawnegg = new B4b_pickupspawnegg(b4b_pickupfallingblock);
            B4b_hitdripstonewithtrident b4b_hitdripstonewithtrident = new B4b_hitdripstonewithtrident(b4b_pickupflint);
            B4b_namechicken b4b_namechicken = new B4b_namechicken(b4b_pickupspawnegg);
            B4b_pickuprarespawnegg b4b_pickuprarespawnegg = new B4b_pickuprarespawnegg(b4b_pickupspawnegg);
            B4b_pickupsuperrarespawnegg b4b_pickupsuperrarespawnegg = new B4b_pickupsuperrarespawnegg(b4b_pickuprarespawnegg);
            B4b_spawnzombiehorse b4b_spawnzombiehorse = new B4b_spawnzombiehorse(b4b_pickupsuperrarespawnegg);
            B4b_useallspawneggs b4b_useallspawneggs = new B4b_useallspawneggs(b4b_spawnzombiehorse);
            B4b_standcenternether b4b_standcenternether = new B4b_standcenternether(b4b_standcenteroverworld);
            B4b_standcenterend b4b_standcenterend = new B4b_standcenterend(b4b_standcenternether);
        b4b_tab1.registerAdvancements(b4b_breakblockfail ,b4b_breaklogsfreely ,b4b_killzombiegetcharcoal ,b4b_breakwithingraceperiod ,b4b_killpiggetdirt ,b4b_pickflower ,b4b_fishgetspawnegg ,b4b_killpolarbeargetice ,b4b_pickallflowers ,b4b_pickupmelonslice ,b4b_fishgetrarestuff ,b4b_killmooshroomgetstuff ,b4b_killphantomgetelytra ,b4b_pickcraftalldyes ,b4b_pickuppumpkin ,b4b_pickupcactus ,b4b_breakleavesfreely ,b4b_breakcraftingtablefreely ,b4b_breakbedfreely ,b4b_breaknyliumfreely ,b4b_spreadnylium ,b4b_placeslimespawner ,b4b_breakandesite ,b4b_pickupvaluablerandomdrop ,b4b_killcreeperorwitchgetrocket ,b4b_killskeletongetstone ,b4b_creeperexplodegetgunpowder ,b4b_killendmobgetenditem ,b4b_collectmobhead ,b4b_killwitherskeletongetblackstone ,b4b_breakstone ,b4b_pickupplayerhead ,b4b_collectallmobheads ,b4b_pickupallmobheads ,b4b_disguise ,b4b_pickupspawner ,b4b_placeskeletonspawner ,b4b_lootobsidian ,b4b_lotsofcobblestone ,b4b_smeltcobblestone ,b4b_usenewblastfurnacerecipe ,b4b_pickupfallingblock ,b4b_breakdirt ,b4b_standcenteroverworld ,b4b_killraidergetclay ,b4b_pickupflint ,b4b_pickupspawnegg ,b4b_hitdripstonewithtrident ,b4b_namechicken ,b4b_pickuprarespawnegg ,b4b_pickupsuperrarespawnegg ,b4b_spawnzombiehorse ,b4b_useallspawneggs ,b4b_bedcmd ,b4b_standcenternether ,b4b_standcenterend ,b4b_killendermangetgrass );
            RootAdvancement b4b_breakblockfailbutfreeinclaim = new RootAdvancement(b4b_tab2, "b4b_breakblockfailbutfreeinclaim", new AdvancementDisplay(Material.ENCHANTED_BOOK, "(DISABLED)Unclaimed Property", AdvancementFrameType.TASK, true, true, 0f, 0f , "Some blocks are free to break, if you have a claim. In this case, you do not."),"textures/block/red_terracotta.png",1);
            B4b_pickupsugarcane b4b_pickupsugarcane = new B4b_pickupsugarcane(b4b_breakblockfailbutfreeinclaim);
            B4b_makepaper b4b_makepaper = new B4b_makepaper(b4b_pickupsugarcane);
            B4b_makebook b4b_makebook = new B4b_makebook(b4b_makepaper);
            B4b_makelectern b4b_makelectern = new B4b_makelectern(b4b_makebook);
            B4b_makewritablebook b4b_makewritablebook = new B4b_makewritablebook(b4b_makebook);
            B4b_claimchunk b4b_claimchunk = new B4b_claimchunk(b4b_makelectern);
            B4b_claimcontestchunk b4b_claimcontestchunk = new B4b_claimcontestchunk(b4b_claimchunk);
            B4b_winclaimcontest b4b_winclaimcontest = new B4b_winclaimcontest(b4b_claimcontestchunk);
            B4b_breakinclaim b4b_breakinclaim = new B4b_breakinclaim(b4b_claimchunk);
            B4b_protectclaimfromallsides b4b_protectclaimfromallsides = new B4b_protectclaimfromallsides(b4b_claimchunk);
            B4b_protectclaimwithgravityblock b4b_protectclaimwithgravityblock = new B4b_protectclaimwithgravityblock(b4b_protectclaimfromallsides);
            B4b_buildirongolem b4b_buildirongolem = new B4b_buildirongolem(b4b_protectclaimwithgravityblock);
            B4b_loseclaimwhileoffline b4b_loseclaimwhileoffline = new B4b_loseclaimwhileoffline(b4b_claimchunk);
            B4b_failblockplaceinclaim b4b_failblockplaceinclaim = new B4b_failblockplaceinclaim(b4b_claimchunk);
            B4b_removeclaim b4b_removeclaim = new B4b_removeclaim(b4b_failblockplaceinclaim);
            B4b_createclaimmap b4b_createclaimmap = new B4b_createclaimmap(b4b_claimchunk);
            B4b_claim5chunks b4b_claim5chunks = new B4b_claim5chunks(b4b_claimchunk);
            B4b_claim10chunks b4b_claim10chunks = new B4b_claim10chunks(b4b_claim5chunks);
            B4b_claim25chunks b4b_claim25chunks = new B4b_claim25chunks(b4b_claim10chunks);
            B4b_claim50chunks b4b_claim50chunks = new B4b_claim50chunks(b4b_claim25chunks);
            B4b_claim100chunks b4b_claim100chunks = new B4b_claim100chunks(b4b_claim50chunks);
            B4b_claim250chunks b4b_claim250chunks = new B4b_claim250chunks(b4b_claim100chunks);
            B4b_claim500chunks b4b_claim500chunks = new B4b_claim500chunks(b4b_claim250chunks);
            B4b_claim1000chunks b4b_claim1000chunks = new B4b_claim1000chunks(b4b_claim500chunks);
            B4b_claim10000chunks b4b_claim10000chunks = new B4b_claim10000chunks(b4b_claim1000chunks);
            B4b_claim100000chunks b4b_claim100000chunks = new B4b_claim100000chunks(b4b_claim10000chunks);
            B4b_intruderalert b4b_intruderalert = new B4b_intruderalert(b4b_claimchunk);
            B4b_createmasterbook b4b_createmasterbook = new B4b_createmasterbook(b4b_makewritablebook);
            B4b_copymasterbook b4b_copymasterbook = new B4b_copymasterbook(b4b_createmasterbook);
            B4b_copymasterbookcopy b4b_copymasterbookcopy = new B4b_copymasterbookcopy(b4b_copymasterbook);
            B4b_putmasterbookinenderchest b4b_putmasterbookinenderchest = new B4b_putmasterbookinenderchest(b4b_copymasterbookcopy);
        b4b_tab2.registerAdvancements(b4b_breakblockfailbutfreeinclaim ,b4b_pickupsugarcane ,b4b_makepaper ,b4b_makebook ,b4b_makelectern ,b4b_makewritablebook ,b4b_claimchunk ,b4b_claimcontestchunk ,b4b_winclaimcontest ,b4b_breakinclaim ,b4b_protectclaimfromallsides ,b4b_protectclaimwithgravityblock ,b4b_buildirongolem ,b4b_loseclaimwhileoffline ,b4b_failblockplaceinclaim ,b4b_removeclaim ,b4b_createclaimmap ,b4b_claim5chunks, b4b_claim10chunks,b4b_claim25chunks ,b4b_claim50chunks ,b4b_claim100chunks ,b4b_claim250chunks ,b4b_claim500chunks ,b4b_claim1000chunks ,b4b_claim10000chunks ,b4b_claim100000chunks ,b4b_intruderalert ,b4b_createmasterbook ,b4b_copymasterbook ,b4b_copymasterbookcopy ,b4b_putmasterbookinenderchest );
    }

    @EventHandler
    public void onJoin(PlayerLoadingCompletedEvent e) {
        // Called after a player has successfully been loaded by the API
        Player p = e.getPlayer();
        // Here you can show tabs to players
        b4b_tab1.showTab(p);
        b4b_tab2.showTab(p);
    }



}
