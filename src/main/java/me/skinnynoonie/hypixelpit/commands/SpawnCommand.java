package me.skinnynoonie.hypixelpit.commands;

import me.skinnynoonie.hypixelpit.loggers.CombatLogger;
import me.skinnynoonie.hypixelpit.utils.MapUtils;
import me.skinnynoonie.hypixelpit.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if(CombatLogger.isInCombat(player)) {
                int secondsTillUnCombat = 16 - CombatLogger.getTimeSinceCombatSeconds(player);
                MessageUtils.sendPlayerMsg(player, "&c&lHOLD UP! &7Can't /respawn while fighting (&c" + secondsTillUnCombat + "s &7left)");
                return true;
            }

            player.teleport(MapUtils.getRandomSpawnLocation());
            player.setHealth(player.getMaxHealth());
            CombatLogger.unCombatLogPlayer(player);
            return true;
        }
        return false;
    }

}
