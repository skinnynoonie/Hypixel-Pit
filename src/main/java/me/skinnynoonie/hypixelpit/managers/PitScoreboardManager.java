package me.skinnynoonie.hypixelpit.managers;

import fr.mrmicky.fastboard.FastBoard;
import me.skinnynoonie.hypixelpit.Main;
import me.skinnynoonie.hypixelpit.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

public class PitScoreboardManager {

    private static final HashMap<UUID, FastBoard> scoreboards = new HashMap<>();
    private static final String dateFormatted = DateTimeFormatter.ofPattern("MM/dd/uu").format(LocalDateTime.now());

    public static void startScoreboardUpdating() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
            for(UUID playerUUID : scoreboards.keySet()) {
                updateBoard(playerUUID, scoreboards.get(playerUUID));
            }
        }, 0, 20);
    }

    public static void registerScoreboard(Player player) {
        FastBoard board = new FastBoard(player);

        board.updateTitle(MessageUtils.translate("&e&lTHE HYPIXEL PIT"));
        scoreboards.putIfAbsent(player.getUniqueId(), board);
    }

    public static void unregisterScoreboard(Player player) {
        scoreboards.remove(player.getUniqueId());
    }

    private static void updateBoard(UUID playerUUID, FastBoard board) {
        Player player = Bukkit.getPlayer(playerUUID);

        board.updateLines(MessageUtils.translateTexts(
                "&7"+dateFormatted+"  &8M5B",
                "",
                "&fPrestige: &eXXXV",
                "&fLevel: &b[120]",
                "Needed XP: &bMAXED",
                "",
                "&fGold: &6" + GoldManager.getGold(player) + "g",
                "",
                "&fStatus: " + StatusManager.getStatus(player),
                "",
                "&ewww.hypixel.net"
        ));
    }

}
