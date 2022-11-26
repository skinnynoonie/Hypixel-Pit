package me.skinnynoonie.hypixelpit.commands;

import me.skinnynoonie.hypixelpit.mysticfacility.MysticOrganizer;
import me.skinnynoonie.hypixelpit.mysticfacility.MysticReformer;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticEnchant;
import me.skinnynoonie.hypixelpit.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class PitEnchantCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;
        if(!player.hasPermission("op")) return true;
        if(strings.length < 2) {
            MessageUtils.sendPlayerMsg(player, "&cSorry, please specify an enchantment and enchantment level!");
            return true;
        }
        MysticEnchant enchant = MysticOrganizer.getMystic(strings[0]);
        if(enchant == null) {
            MessageUtils.sendPlayerMsg(player, "&cThe enchant you entered is not valid!");
            return true;
        }
        if(!Arrays.asList("1","2","3").contains(strings[1])) {
            MessageUtils.sendPlayerMsg(player, "&cThe tier you specified is not valid, please choose from 1, 2, or 3!");
            return true;
        }
        byte tier = Byte.parseByte(strings[1]);
        if(!MysticReformer.addEnchantSafe(player.getItemInHand(), enchant, tier)) {
            MessageUtils.sendPlayerMsg(player, "&cSorry, something went wrong!");
            MessageUtils.sendPlayerMsg(player, "&cPlease make sure your item is a mystic, or that it can hold the enchant.");
            return true;
        }
        MessageUtils.sendPlayerMsg(player, "&aEnchant applied!");
        return true;
    }

}
