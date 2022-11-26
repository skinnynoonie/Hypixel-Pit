package me.skinnynoonie.hypixelpit;

import me.skinnynoonie.hypixelpit.loggers.CombatLogger;
import me.skinnynoonie.hypixelpit.managers.ComboCounterManager;
import me.skinnynoonie.hypixelpit.managers.CooldownManager;
import me.skinnynoonie.hypixelpit.managers.GoldManager;
import me.skinnynoonie.hypixelpit.managers.PitScoreboardManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        PitScoreboardManager.unregisterScoreboard(player);
        event.setQuitMessage("");
        GoldManager.deleteGold(player);
        CombatLogger.unlogPlayer(player);
        CooldownManager.unregisterCooldown(player);
        ComboCounterManager.unregisterComboTracker(player);
    }

}
