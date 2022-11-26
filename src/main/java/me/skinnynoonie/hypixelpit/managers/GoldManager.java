package me.skinnynoonie.hypixelpit.managers;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class GoldManager {

    private static final HashMap<UUID, Long> goldData = new HashMap<>();

    public static void setGold(Player player, Long amount) {
        goldData.put(player.getUniqueId(), amount);
    }

    public static long getGold(Player player) {
        return goldData.get(player.getUniqueId());
    }

    public static void deleteGold(Player player) {
        goldData.remove(player.getUniqueId());
    }

}
