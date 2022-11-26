package me.skinnynoonie.hypixelpit.commands;

import me.skinnynoonie.hypixelpit.mysticfacility.MysticOrganizer;
import me.skinnynoonie.hypixelpit.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PitEnchantsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;
        int i = 0;
        for(String enchant : MysticOrganizer.getRegisteredMysticKeys()) {
            i++;
            MessageUtils.sendPlayerMsg(player,
                    "&6" + i + ". &7" + enchant + "&r " + MysticOrganizer.getMystic(enchant).getDisplayName()
            );
        }
        return true;
    }
}
