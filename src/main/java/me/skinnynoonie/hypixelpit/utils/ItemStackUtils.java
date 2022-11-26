package me.skinnynoonie.hypixelpit.utils;

import de.tr7zw.changeme.nbtapi.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.UUID;

public class ItemStackUtils {

    public static void setLore(ItemStack item, String... lore) {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setLore(MessageUtils.translateTexts(lore));
        item.setItemMeta(itemMeta);
    }

    public static void removeLore(ItemStack item, List<String> lore) {
        ItemMeta itemMeta = item.getItemMeta();
        List<String> itemLore = itemMeta.getLore();
        itemLore.removeAll(lore);
        itemMeta.setLore(itemLore);
        item.setItemMeta(itemMeta);
    }

    public static void setLoreIndex(ItemStack item, String lore, int index) {
        ItemMeta itemMeta = item.getItemMeta();
        List<String> itemLore = itemMeta.getLore();
        itemLore.set(index, MessageUtils.translate(lore));
        itemMeta.setLore(itemLore);
        item.setItemMeta(itemMeta);
    }

    public static void hideUnbreakable(ItemStack item) {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(itemMeta);
    }

    public static void setName(ItemStack item, String name) {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(MessageUtils.translate(name));
        item.setItemMeta(itemMeta);
    }

    public static void setByteNBTTag(ItemStack item, String key, byte value) {
        NBTItem itemNBT = new NBTItem(item);
        itemNBT.setByte(key, value);
        item.setItemMeta(itemNBT.getItem().getItemMeta());
    }

    public static void addEnchantGlare(ItemStack item) {
        item.addUnsafeEnchantment(Enchantment.LURE, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(itemMeta);
    }

    public static void setItemDamage(ItemStack item, double damage) {
        NBTItem itemNBT = new NBTItem(item);
        NBTCompoundList attributeList = itemNBT.getCompoundList("AttributeModifiers");
        NBTCompound attribute = new NBTContainer();
        UUID uuid = UUID.randomUUID();
        attribute.setDouble("Amount",damage);
        attribute.setString("AttributeName","generic.attackDamage");
        attribute.setString("Name","generic.attackDamage");
        attribute.setInteger("Operation",0);
        attribute.setLong("UUIDLeast",uuid.getLeastSignificantBits());
        attribute.setLong("UUIDMost",uuid.getMostSignificantBits());
        attributeList.addCompound(attribute);
        item.setItemMeta(itemNBT.getItem().getItemMeta());
    }

}
