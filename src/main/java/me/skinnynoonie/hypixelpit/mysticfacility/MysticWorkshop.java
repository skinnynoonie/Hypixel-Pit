package me.skinnynoonie.hypixelpit.mysticfacility;

import me.skinnynoonie.hypixelpit.mysticfacility.properties.FreshMysticType;
import me.skinnynoonie.hypixelpit.utils.ColorUtils;
import me.skinnynoonie.hypixelpit.utils.ItemStackUtils;
import me.skinnynoonie.hypixelpit.utils.RomanNumeralUtils;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;


public class MysticWorkshop {

    public static ItemStack getMystic(FreshMysticType mysticType, byte tier, Color pantsColor) {
        if((tier != 1) & (tier != 2) & (tier != 3)) {
            if (mysticType == FreshMysticType.BOW) return createFreshBow();
            if (mysticType == FreshMysticType.SWORD) return createFreshSword();
            if (mysticType == FreshMysticType.PANTS) return createFreshPants(pantsColor);
        }
        if (mysticType == FreshMysticType.BOW) return createMysticBow(tier);
        if (mysticType == FreshMysticType.SWORD) return createMysticSword(tier);
        if (mysticType == FreshMysticType.PANTS) return createMysticPants(tier, pantsColor);
        return null;
    }

    public static ItemStack getMystic(FreshMysticType mysticType, byte tier) {
        return getMystic(mysticType, tier, null);
    }

    private static ItemStack createFreshBow() {
        ItemStack freshBowBase = new ItemStack(Material.BOW);
        ItemStackUtils.setName(freshBowBase, "&bMystic Bow");
        ItemStackUtils.setLore(freshBowBase,
                "&7Kept on death",
                "",
                "&7Used in the mystic well"
        );
        ItemStackUtils.setByteNBTTag(freshBowBase, "tier", (byte) 0);
        ItemStackUtils.addEnchantGlare(freshBowBase);
        freshBowBase.getItemMeta().spigot().setUnbreakable(true);
        return freshBowBase;
    }

    private static ItemStack createFreshSword() {
        ItemStack freshSwordBase = new ItemStack(Material.GOLD_SWORD);
        ItemStackUtils.setName(freshSwordBase, "&eMystic Sword");
        ItemStackUtils.setLore(freshSwordBase,
                "&7Kept on death",
                "",
                "&7Used in the mystic well"
        );
        ItemStackUtils.setByteNBTTag(freshSwordBase, "tier", (byte) 0);
        freshSwordBase.getItemMeta().spigot().setUnbreakable(true);
        ItemStackUtils.setItemDamage(freshSwordBase, 6.5);
        return freshSwordBase;
    }

    private static ItemStack createFreshPants(Color color) {
        if(color == null) return null;
        ItemStack freshPantBase = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta freshPantBaseItemMeta = freshPantBase.getItemMeta();
        LeatherArmorMeta freshPantBaseLeatherMeta = (LeatherArmorMeta) freshPantBaseItemMeta;
        freshPantBaseLeatherMeta.setColor(color);
        freshPantBase.setItemMeta(freshPantBaseItemMeta);
        ChatColor pantsColor = ColorUtils.colorToChatColor(color);
        String pantsColorString = ColorUtils.colorToString(color);
        ItemStackUtils.setName(freshPantBase, pantsColor + "Fresh " + pantsColorString + " Pants");
        ItemStackUtils.setLore(freshPantBase,
                "&7Kept on death",
                "",
                pantsColor + "Used in the mystic well",
                pantsColor + "Also, a fashion statement"
        );
        freshPantBase.getItemMeta().spigot().setUnbreakable(true);
        ItemStackUtils.setByteNBTTag(freshPantBase, "tier", (byte) 0);
        return freshPantBase;
    }

    private static ItemStack createMysticBow(byte tier) {
        ItemStack mysticBowBase = new ItemStack(Material.BOW);
        String romanNumeralTier = RomanNumeralUtils.byteToNumeral(tier);
        ItemStackUtils.setName(mysticBowBase, "&cTier " + romanNumeralTier + " Bow");
        ItemStackUtils.setLore(mysticBowBase, "&7Lives: &a∞&7/∞", "");
        ItemStackUtils.setByteNBTTag(mysticBowBase, "tier", tier);
        ItemStackUtils.addEnchantGlare(mysticBowBase);
        mysticBowBase.getItemMeta().spigot().setUnbreakable(true);
        return mysticBowBase;
    }

    private static ItemStack createMysticSword(byte tier) {
        ItemStack mysticSwordBase = new ItemStack(Material.GOLD_SWORD);
        String romanNumeralTier = RomanNumeralUtils.byteToNumeral(tier);
        ItemStackUtils.setName(mysticSwordBase, "&cTier " + romanNumeralTier + " Sword");
        ItemStackUtils.setLore(mysticSwordBase, "&7Lives: &a∞&7/∞", "");
        ItemStackUtils.setByteNBTTag(mysticSwordBase, "tier", tier);
        mysticSwordBase.getItemMeta().spigot().setUnbreakable(true);
        ItemStackUtils.hideUnbreakable(mysticSwordBase);
        ItemStackUtils.setItemDamage(mysticSwordBase, 6.5);
        ItemStackUtils.addEnchantGlare(mysticSwordBase);
        return mysticSwordBase;
    }

    private static ItemStack createMysticPants(byte tier, Color color) {
        if(color == null) return null;
        ItemStack mysticPantBase = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta freshPantBaseItemMeta = mysticPantBase.getItemMeta();
        LeatherArmorMeta mysticPantBaseLeatherMeta = (LeatherArmorMeta) freshPantBaseItemMeta;
        mysticPantBaseLeatherMeta.setColor(color);
        mysticPantBase.setItemMeta(freshPantBaseItemMeta);
        ChatColor pantsColor = ColorUtils.colorToChatColor(color);
        String pantsColorString = ColorUtils.colorToString(color);
        String romanNumeralTier = RomanNumeralUtils.byteToNumeral(tier);
        ItemStackUtils.setName(mysticPantBase, pantsColor + "Tier " + romanNumeralTier + " " + pantsColorString + " Pants");
        ItemStackUtils.setLore(mysticPantBase, "&7Lives: &a∞&7/∞", "", pantsColor + "As strong as iron");
        mysticPantBase.getItemMeta().spigot().setUnbreakable(true);
        ItemStackUtils.setByteNBTTag(mysticPantBase, "tier", tier);
        return mysticPantBase;
    }

}
