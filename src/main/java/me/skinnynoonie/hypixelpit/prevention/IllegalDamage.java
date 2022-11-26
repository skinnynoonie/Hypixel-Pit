package me.skinnynoonie.hypixelpit.prevention;

import me.skinnynoonie.hypixelpit.utils.MapUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class IllegalDamage implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onDamage(EntityDamageEvent event) {
        if(!(event.getEntity() instanceof Player)) return;

        EntityDamageEvent.DamageCause dmgCause = event.getCause();

        if(MapUtils.isInSpawn(event.getEntity().getLocation()))
            event.setCancelled(true);
        if(dmgCause == EntityDamageEvent.DamageCause.POISON) event.setCancelled(true);
        if(dmgCause == EntityDamageEvent.DamageCause.FALL) event.setCancelled(true);
        if(dmgCause == EntityDamageEvent.DamageCause.FIRE) event.setCancelled(true);
    }

}
