package me.skinnynoonie.hypixelpit.mysticfacility;

import de.tr7zw.changeme.nbtapi.NBTItem;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.FreshMysticType;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticEnchant;
import me.skinnynoonie.hypixelpit.utils.ItemStackUtils;
import me.skinnynoonie.hypixelpit.utils.RomanNumeralUtils;
import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;


public class MysticReformer {

    public static boolean addEnchantSafe(ItemStack item, MysticEnchant enchant, byte tier) {
        if(!MysticInspector.isMystic(item)) return false;
        if(MysticInspector.getType(item) != enchant.getType()) return false;
        if(new NBTItem(item).getKeys().contains(enchant.getReferenceName())) return false;
        if(MysticInspector.getTier(item) >= 3) return false;
        upgradeMysticTier(item);
        addEnchantUnsafe(item, enchant, tier);
        return true;
    }

    public static void addEnchantUnsafe(ItemStack item, MysticEnchant enchant, byte tier) {
        List<String> description = new ArrayList<>();
        description.add(enchant.getDisplayName() + RomanNumeralUtils.byteToNumeral(tier));
        description.addAll(enchant.getDescription(tier));
        description.add("");
        MysticDescriptionInjector.injectLore(item, description);
        fixLoreOnSword(item);
        ItemStackUtils.setByteNBTTag(item, enchant.getReferenceName(), tier);
    }

    public static void upgradeMysticTier(ItemStack item) {
        if(!MysticInspector.isMystic(item)) return;
        byte tier = MysticInspector.getTier(item);
        if(tier >= 3) return;
        ItemStackUtils.setByteNBTTag(item, "tier", (byte) (tier + 1));
        FreshMysticType mysticType = MysticInspector.getType(item);
        Color pantsColor = MysticInspector.getPantsColor(item);
        ItemMeta newItemMeta = MysticWorkshop.getMystic(mysticType, (byte) (tier + 1), pantsColor).getItemMeta();
        if(tier == 0) item.setItemMeta(newItemMeta);
        else ItemStackUtils.setName(item, newItemMeta.getDisplayName());
    }

    public static void downgradeMysticTier(ItemStack item) {
        if(!MysticInspector.isMystic(item)) return;
        byte tier = MysticInspector.getTier(item);
        if(tier <= 0) return;
        ItemStackUtils.setByteNBTTag(item, "tier", (byte) (tier - 1));
        FreshMysticType mysticType = MysticInspector.getType(item);
        Color pantsColor = MysticInspector.getPantsColor(item);
        ItemMeta newItemMeta = MysticWorkshop.getMystic(mysticType, (byte) (tier - 1), pantsColor).getItemMeta();
        if(tier == 1) item.setItemMeta(newItemMeta);
        else ItemStackUtils.setName(item, newItemMeta.getDisplayName());
    }

    public static void fixLoreOnSword(ItemStack item) {
        if(MysticInspector.getType(item) != FreshMysticType.SWORD) return;
        ItemMeta itemMeta = item.getItemMeta();
        List<String> itemLore = itemMeta.getLore();
        itemLore.remove(itemLore.size() - 1);
        itemMeta.setLore(itemLore);
        item.setItemMeta(itemMeta);
    }

}
