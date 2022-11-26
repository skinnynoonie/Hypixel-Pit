package me.skinnynoonie.hypixelpit.managers;

import me.skinnynoonie.hypixelpit.loggers.CombatLogger;
import me.skinnynoonie.hypixelpit.utils.MapUtils;
import me.skinnynoonie.hypixelpit.utils.MessageUtils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

public class DeathManager {

    public static void death(EntityDamageEvent event, Player victim, Player attacker) {
        event.setCancelled(true);
        CombatLogger.unCombatLogPlayer(victim);
        victim.getWorld().playSound(victim.getLocation(), Sound.HURT_FLESH, 1, 1);
        victim.teleport(MapUtils.getRandomSpawnLocation());
        victim.setHealth(victim.getMaxHealth());

        if(attacker == null) MessageUtils.sendPlayerMsg(victim, getVictimPOV(null));
        else {
            MessageUtils.sendPlayerMsg(victim, getVictimPOV(attacker.getName()));
            MessageUtils.sendPlayerMsg(attacker, getAttackerPOV(victim.getName()));
        }
    }

    public static String getVictimPOV(String attackerName) {
        if(attackerName == null) return MessageUtils.translate("&c&lDEATH!");
        return MessageUtils.translate("&c&lDEATH! &7by &b[120] &7" + attackerName + " &e&lVIEW RECAP");
    }

    public static String getAttackerPOV(String victimName) {
        return MessageUtils.translate("&a&lKILL! &7on &b[120] &7" + victimName);
    }

}
