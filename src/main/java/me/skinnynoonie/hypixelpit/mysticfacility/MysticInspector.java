package me.skinnynoonie.hypixelpit.mysticfacility;

import de.tr7zw.changeme.nbtapi.NBTItem;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.FreshMysticType;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticEnchant;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.HashMap;

public class MysticInspector {

    public static byte getTier(ItemStack item) {
        return new NBTItem(item).getByte("tier");
    }

    public static FreshMysticType getType(ItemStack item) {
        if(!isMystic(item)) return null;
        Material itemType = item.getType();
        if(itemType == Material.BOW) return FreshMysticType.BOW;
        if(itemType == Material.GOLD_SWORD) return FreshMysticType.SWORD;
        if(itemType == Material.LEATHER_LEGGINGS) return FreshMysticType.PANTS;
        return null;
    }

    public static Color getPantsColor(ItemStack item) {
        if(item.getType() != Material.LEATHER_LEGGINGS) return null;
        LeatherArmorMeta leatherMeta = (LeatherArmorMeta) item.getItemMeta();
        return leatherMeta.getColor();
    }

    public static HashMap<MysticEnchant, Byte> getMysticEnchants(ItemStack item) {
        HashMap<MysticEnchant, Byte> hashNBT = new HashMap<>();
        NBTItem itemNBT = new NBTItem(item);
        for(String key : itemNBT.getKeys()) {
            if(MysticOrganizer.getMystic(key) == null) continue;
            hashNBT.put(MysticOrganizer.getMystic(key), itemNBT.getByte(key));
        }
        return hashNBT;
    }

    public static boolean isMystic(ItemStack item) {
        if(item.getType() == null) return false;
        if(item.getType() == Material.AIR) return false;
        return new NBTItem(item).getKeys().contains("tier");
    }

}
