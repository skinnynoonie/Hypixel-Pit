package me.skinnynoonie.hypixelpit.utils;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class EventUtils {

    //EDEE stands for EntityDamageEvent
    public static Player getAttackerFromEDE(EntityDamageEvent event) {
        if(!(event instanceof EntityDamageByEntityEvent)) return null;
        Entity attackerEntity = ((EntityDamageByEntityEvent) event).getDamager();

        if(attackerEntity instanceof Player) return (Player) attackerEntity;
        if(!(attackerEntity instanceof Projectile)) return null;

        Projectile attackerProjectile = (Projectile) attackerEntity;

        if(attackerProjectile.getShooter() instanceof Player) return (Player) attackerProjectile.getShooter();
        return null;
    }

}
