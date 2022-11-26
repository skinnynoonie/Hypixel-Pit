package me.skinnynoonie.hypixelpit.visuals;

import me.skinnynoonie.hypixelpit.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scoreboard.Team;

public class PlayerLevelDisplay implements Listener {

    private static Team mainTeam;

    public static void registerTablistName(Player player) {
        String name = ChatColor.GRAY + player.getName();
        String displayPrestige = MessageUtils.translate("&b[120]");

        player.setPlayerListName(displayPrestige + " " + name);
    }

    public static void registerMainTeam() {
        mainTeam = Bukkit.getScoreboardManager().getNewScoreboard().registerNewTeam("mainTeam");

        mainTeam.setPrefix(MessageUtils.translate("&b[&l120&b] &7"));
    }

    public static void registerNameTag(Player player) {
        mainTeam.addEntry(player.getName());
        player.setScoreboard(mainTeam.getScoreboard());
    }

    public static void unregisterMainTeam() {
        mainTeam.unregister();
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        String playerName = ChatColor.GRAY + event.getPlayer().getName();
        String displayPrestige = MessageUtils.translate("&b[&eXXXV&b-120]");

        event.setFormat(displayPrestige + " " + playerName + ": " + message);

    }

}
