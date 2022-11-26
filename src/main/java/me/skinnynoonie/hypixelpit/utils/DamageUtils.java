package me.skinnynoonie.hypixelpit.utils;

import net.minecraft.server.v1_8_R3.DamageSource;
import net.minecraft.server.v1_8_R3.EntityHuman;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;


public class DamageUtils {

    public static void dealTrueDamage(Player victim, Player attacker, float amount) {

        PlayerInventory victimInventory = victim.getInventory();
        ItemStack[] armorContents = victimInventory.getArmorContents();

        victimInventory.setArmorContents(new ItemStack[]{
                new ItemStack(Material.AIR),
                new ItemStack(Material.AIR), new ItemStack(Material.AIR),
                new ItemStack(Material.AIR)
        });
        victim.setNoDamageTicks(0);
        victim.damage(amount, attacker);
        victimInventory.setArmorContents(armorContents);
        ((CraftPlayer) victim).getHandle().damageEntity(DamageSource.playerAttack(((CraftPlayer) attacker).getHandle()), amount);



        //((CraftPlayer) victim).getHandle().damageEntity(DamageSource.MAGIC, amount);
    }

}
