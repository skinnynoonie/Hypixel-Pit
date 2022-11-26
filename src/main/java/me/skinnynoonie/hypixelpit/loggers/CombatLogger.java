package me.skinnynoonie.hypixelpit.loggers;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class CombatLogger {

    private final static HashMap<UUID, Long> loggedCombatTimes = new HashMap<>();

    public static void logNow(Player player) {
        loggedCombatTimes.put(player.getUniqueId(), System.currentTimeMillis());
    }

    public static void unlogPlayer(Player player) {
        loggedCombatTimes.remove(player.getUniqueId());
    }

    public static boolean isInCombat(Player player) {
        if(getTimeSinceCombat(player) >= 15000) return false;
        return true;
    }

    public static Long getTimeSinceCombat(Player player) {
        return System.currentTimeMillis() - loggedCombatTimes.get(player.getUniqueId());
    }

    public static void unCombatLogPlayer(Player player) {
        loggedCombatTimes.put(player.getUniqueId(), 0L);
    }

    public static int getTimeSinceCombatSeconds(Player player) {
        return (int) Math.ceil(getTimeSinceCombat(player) / 1000.0);
    }


}
