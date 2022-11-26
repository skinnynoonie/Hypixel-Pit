package me.skinnynoonie.hypixelpit.managers;

import me.skinnynoonie.hypixelpit.mysticfacility.MysticInspector;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.FreshMysticType;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticEnchant;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticInteractionType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;


public class ShootingManager implements Listener {

    @EventHandler
    public void onShoot(EntityShootBowEvent event) {
        if(event.getEntityType() != EntityType.PLAYER) return;
        if(event.isCancelled()) return;
        Player player = (Player) event.getEntity();

        ItemStack bow = player.getItemInHand();
        if(MysticInspector.getType(bow) == FreshMysticType.BOW) {
            HashMap<MysticEnchant, Byte> bowEnchants = MysticInspector.getMysticEnchants(bow);
            for (MysticEnchant enchant : bowEnchants.keySet()) {
                if (enchant.getEventType() != MysticInteractionType.ShooterShootBow) continue;
                enchant.execute(event, bowEnchants.get(enchant));
            }
        }

    }

}
