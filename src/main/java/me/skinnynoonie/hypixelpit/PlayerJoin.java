package me.skinnynoonie.hypixelpit;

import me.skinnynoonie.hypixelpit.loggers.CombatLogger;
import me.skinnynoonie.hypixelpit.managers.GoldManager;
import me.skinnynoonie.hypixelpit.managers.PitScoreboardManager;
import me.skinnynoonie.hypixelpit.utils.MapUtils;
import me.skinnynoonie.hypixelpit.visuals.PlayerLevelDisplay;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage("");
        PlayerLevelDisplay.registerTablistName(player);
        player.setGameMode(GameMode.SURVIVAL);
        player.setLevel(120);
        player.setExp(0.999f);
        player.setMaxHealth(20);
        player.setHealth(player.getMaxHealth());
        player.setFoodLevel(20);
        player.setGameMode(GameMode.SURVIVAL);
        player.teleport(MapUtils.getRandomSpawnLocation());
        PlayerLevelDisplay.registerNameTag(player);
        PitScoreboardManager.registerScoreboard(player);
        GoldManager.setGold(player, 123414112L);
        CombatLogger.unCombatLogPlayer(player);
    }

}
