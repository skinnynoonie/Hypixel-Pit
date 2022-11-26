package me.skinnynoonie.hypixelpit.managers;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class ComboCounterManager {

    private static final HashMap<UUID, HashMap<String, Integer>> comboTracker = new HashMap<>();

    public static void addCombo(Player player, String comboKey, Integer comboAmount) {
        if(comboTracker.get(player.getUniqueId()) == null) comboTracker.put(player.getUniqueId(), new HashMap<>());
        comboTracker.get(player.getUniqueId()).put(comboKey, getComboAmount(player, comboKey) + comboAmount);
    }

    public static void setCombo(Player player, String comboKey, Integer amount) {
        if(comboTracker.get(player.getUniqueId()) == null) comboTracker.put(player.getUniqueId(), new HashMap<>());
        comboTracker.get(player.getUniqueId()).put(comboKey, amount);
    }

    public static Integer getComboAmount(Player player, String comboKey) {
        if(comboTracker.get(player.getUniqueId()) == null) return 0;
        if(comboTracker.get(player.getUniqueId()).get(comboKey) == null) return 0;
        return comboTracker.get(player.getUniqueId()).get(comboKey);
    }

    public static void unregisterComboTracker(Player player) {
        comboTracker.remove(player.getUniqueId());
    }

}
