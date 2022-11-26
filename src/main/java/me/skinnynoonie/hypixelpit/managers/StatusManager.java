package me.skinnynoonie.hypixelpit.managers;

import me.skinnynoonie.hypixelpit.loggers.CombatLogger;
import me.skinnynoonie.hypixelpit.utils.MessageUtils;
import org.bukkit.entity.Player;

public class StatusManager {

    public static String getStatus(Player player) {
        if(CombatLogger.isInCombat(player)) {
            Long timeSinceCombat = CombatLogger.getTimeSinceCombat(player);
            if(timeSinceCombat < 10000) return MessageUtils.translate("&cFighting");
            if(timeSinceCombat >= 14000) return MessageUtils.translate("&cFighting &7(1)");
            if(timeSinceCombat >= 13000) return MessageUtils.translate("&cFighting &7(2)");
            if(timeSinceCombat >= 12000) return MessageUtils.translate("&cFighting &7(3)");
            if(timeSinceCombat >= 11000) return MessageUtils.translate("&cFighting &7(4)");
            if(timeSinceCombat >= 10000) return MessageUtils.translate("&cFighting &7(5)");
        }return MessageUtils.translate("&aIdling");
    }

}
