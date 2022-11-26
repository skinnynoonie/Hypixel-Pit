package me.skinnynoonie.hypixelpit.commands;

import me.skinnynoonie.hypixelpit.mysticfacility.MysticWorkshop;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.FreshMysticType;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveAllFreshCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;
        if (!player.hasPermission("op")) return false;
        player.getInventory().addItem(
                MysticWorkshop.getMystic(FreshMysticType.BOW, (byte) 0),
                MysticWorkshop.getMystic(FreshMysticType.SWORD, (byte) 0),
                MysticWorkshop.getMystic(FreshMysticType.PANTS, (byte) 0, Color.RED)
        );
        return true;
    }

}
