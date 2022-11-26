package me.skinnynoonie.hypixelpit.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class GiveProtCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;
        if(!player.hasPermission("op")) return true;

        ArrayList<Material> armour = new ArrayList<>(Arrays.asList(
                Material.DIAMOND_HELMET,
                Material.DIAMOND_CHESTPLATE,
                Material.DIAMOND_LEGGINGS,
                Material.DIAMOND_BOOTS
        ));

        for(Material item : armour) {

            ItemStack itemStackItem = new ItemStack(item);
            itemStackItem.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
            itemStackItem.getItemMeta().spigot().setUnbreakable(true);
            player.getInventory().addItem(itemStackItem);

        }

        return true;
    }

}
