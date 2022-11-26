package me.skinnynoonie.hypixelpit.utils;

import org.bukkit.entity.Player;

public class PlayerUtils {

    public static void heal(Player player, double amount) {
        if(amount <= 0) return;
        player.setHealth(
                Math.max(amount, player.getMaxHealth())
        );
    }

}
