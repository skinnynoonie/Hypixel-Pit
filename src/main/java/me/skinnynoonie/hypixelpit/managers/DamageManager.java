package me.skinnynoonie.hypixelpit.managers;

import me.skinnynoonie.hypixelpit.loggers.CombatLogger;
import me.skinnynoonie.hypixelpit.utils.EventUtils;
import me.skinnynoonie.hypixelpit.utils.MessageUtils;
import me.skinnynoonie.hypixelpit.visuals.DamageActionBar;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;


public class DamageManager implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDamage(EntityDamageEvent event) {
        if(event.isCancelled()) return;
        if(event.getEntityType() != EntityType.PLAYER) return;

        Player victim = (Player) event.getEntity();
        Player attacker = EventUtils.getAttackerFromEDE(event);
        double victimHealth = victim.getHealth();
        double victimMaxHealth = victim.getMaxHealth();
        double finalDamage = event.getFinalDamage();
        String victimName = victim.getName();

        if(attacker != null) {
            MessageUtils.sendActionBar(attacker,
                    new DamageActionBar(victimName, victimHealth, finalDamage, victimMaxHealth).getOutput()
            );
            CombatLogger.logNow(attacker);
            CombatLogger.logNow(victim);
        }

        if(victimHealth - finalDamage <= 0)
            DeathManager.death(event, victim, attacker);

    }

}
