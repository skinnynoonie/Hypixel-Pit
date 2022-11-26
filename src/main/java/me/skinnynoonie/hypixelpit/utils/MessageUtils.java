package me.skinnynoonie.hypixelpit.utils;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class MessageUtils {

    public static List<String> translateTexts(String... texts) {
        List<String> translatedText = new ArrayList<>();
        for(String text : texts) {
            translatedText.add(ChatColor.translateAlternateColorCodes('&', text));
        }
        return translatedText;
    }

    public static String translate(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static void sendPlayerMsg(Player player, String message) {
        message = translate(message);
        player.sendMessage(message);
    }

    public static void sendConsoleMsg(String message) {
        message = translate(message);
        Bukkit.getConsoleSender().sendMessage(message);
    }

    public static void sendActionBar(Player player, String message) {
        message = translate(message);
        PacketPlayOutChat packet = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + message + "\"}"), (byte) 2);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

}
