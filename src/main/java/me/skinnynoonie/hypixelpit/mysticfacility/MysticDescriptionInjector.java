package me.skinnynoonie.hypixelpit.mysticfacility;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MysticDescriptionInjector {

    public static void injectLore(ItemStack item, List<String> lore) {
        if(lore == null) return;
        if(lore.size() == 0) return;

        ItemMeta itemMeta = item.getItemMeta();
        List<String> itemLore = itemMeta.getLore();
        if(itemLore == null) return;

        short injectionPoint = 2;
        if(lore.size() < 2) injectionPoint = 1;

        Collections.reverse(lore);
        for(String loreDesc : lore)
            itemLore.add(injectionPoint, loreDesc);

        itemMeta.setLore(itemLore);
        item.setItemMeta(itemMeta);
    }

    public static void injectLore(ItemStack item, String... lore) {
        injectLore(item, Arrays.asList(lore));
    }

}
