package me.skinnynoonie.hypixelpit.utils;

import org.bukkit.ChatColor;
import org.bukkit.Color;

import java.util.HashMap;

public class ColorUtils {

    public static ChatColor colorToChatColor(Color color) {
        HashMap<Color, ChatColor> colorChatColorHashMap = new HashMap<>();

        colorChatColorHashMap.put(Color.LIME, ChatColor.GREEN);
        colorChatColorHashMap.put(Color.RED, ChatColor.RED);
        colorChatColorHashMap.put(Color.BLUE, ChatColor.BLUE);
        colorChatColorHashMap.put(Color.YELLOW, ChatColor.YELLOW);
        colorChatColorHashMap.put(Color.ORANGE, ChatColor.GOLD);

        return colorChatColorHashMap.get(color);
    }

    public static String colorToString(Color color) {
        HashMap<Color, String> colorStringHashMap = new HashMap<>();

        colorStringHashMap.put(Color.LIME, "Green");
        colorStringHashMap.put(Color.RED, "Red");
        colorStringHashMap.put(Color.BLUE, "Blue");
        colorStringHashMap.put(Color.YELLOW, "Yellow");
        colorStringHashMap.put(Color.ORANGE, "Orange");

        return colorStringHashMap.get(color);
    }

}
