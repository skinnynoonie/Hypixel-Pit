package me.skinnynoonie.hypixelpit;

import de.tr7zw.changeme.nbtapi.NBTEntity;
import de.tr7zw.changeme.nbtapi.NBTItem;
import me.skinnynoonie.hypixelpit.mysticfacility.MysticWorkshop;
import me.skinnynoonie.hypixelpit.mysticfacility.MysticReformer;
import me.skinnynoonie.hypixelpit.mysticfacility.mysticenchants.bows.MegaLongbow;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.FreshMysticType;

import org.bukkit.Color;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class TEST implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if(event.getAction() != Action.RIGHT_CLICK_AIR) return;

        Player player = event.getPlayer();
        //MysticDescriptionInjector.injectLore(player.getInventory().getItemInHand(), new MegaLongbow().getDescription((byte) 1));
        //MysticReformer.upgradeMysticTier(event.getPlayer().getItemInHand());
        //MysticReformer.downgradeMysticTier(event.getPlayer().getItemInHand());
        //MysticReformer.addEnchantSafe(player.getItemInHand(), new MegaLongbow(), (byte) 3);
        //System.out.println(new NBTItem(event.getItem()).toString());
        //player.getInventory().addItem(
        //        MysticWorkshop.getMystic(FreshMysticType.BOW, (byte) 0),
        //        MysticWorkshop.getMystic(FreshMysticType.SWORD, (byte) 0),
        //        MysticWorkshop.getMystic(FreshMysticType.PANTS, (byte) 0, Color.RED)
        //);
    }

    @EventHandler
    public void onShoot(EntityShootBowEvent event) {

    }

}
