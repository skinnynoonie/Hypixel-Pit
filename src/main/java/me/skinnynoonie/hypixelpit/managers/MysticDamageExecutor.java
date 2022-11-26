package me.skinnynoonie.hypixelpit.managers;

import me.skinnynoonie.hypixelpit.mysticfacility.MysticInspector;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.FreshMysticType;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticEnchant;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticInteractionType;
import me.skinnynoonie.hypixelpit.utils.EventUtils;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class MysticDamageExecutor implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onDamage(EntityDamageEvent event) {
        if (event.isCancelled()) return;
        if (event.getEntityType() != EntityType.PLAYER) return;

        Player attacker = EventUtils.getAttackerFromEDE(event);
        if(attacker == null) return;

        Player victim = (Player) event.getEntity();
        ItemStack attackerTool = attacker.getItemInHand();

        if(MysticInspector.getType(victim.getItemInHand()) == FreshMysticType.SWORD)
            executeEnchants(victim.getItemInHand(), event, MysticInteractionType.VictimHoldSwordWhenDamaged);

        if(event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
            if(!event.isCancelled())
                if (MysticInspector.getType(attackerTool) == FreshMysticType.BOW)
                    executeEnchants(attackerTool, event, MysticInteractionType.VictimDamageByArrow);
        }

        if(event.getCause() == EntityDamageEvent.DamageCause.CONTACT) {
            if(MysticInspector.getType(attackerTool) == FreshMysticType.SWORD){
                executeEnchants(attackerTool, event, MysticInteractionType.AttackerHitVictim);
            }
        }

    }

    private static void executeEnchants(ItemStack item, Event event, MysticInteractionType interaction) {
        HashMap<MysticEnchant, Byte> mysticEnchants = MysticInspector.getMysticEnchants(item);
        for(MysticEnchant enchant : mysticEnchants.keySet()) {
            if(enchant.getEventType() != interaction) continue;
            enchant.execute(event, mysticEnchants.get(enchant));
        }
    }

}
