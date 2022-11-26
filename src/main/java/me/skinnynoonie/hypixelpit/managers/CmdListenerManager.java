package me.skinnynoonie.hypixelpit.managers;

import me.skinnynoonie.hypixelpit.Main;
import me.skinnynoonie.hypixelpit.PlayerJoin;
import me.skinnynoonie.hypixelpit.PlayerLeave;
import me.skinnynoonie.hypixelpit.TEST;
import me.skinnynoonie.hypixelpit.commands.*;
import me.skinnynoonie.hypixelpit.loggers.BlockLogger;
import me.skinnynoonie.hypixelpit.prevention.IllegalBlocks;
import me.skinnynoonie.hypixelpit.prevention.IllegalDamage;
import me.skinnynoonie.hypixelpit.prevention.OtherPrevention;
import me.skinnynoonie.hypixelpit.visuals.PlayerLevelDisplay;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CmdListenerManager {

    public static void registerListeners() {
        Listener[] listeners = new Listener[]{
                new GameruleManager(),
                new PlayerLevelDisplay(),
                new PlayerJoin(),
                new PlayerLeave(),
                new IllegalBlocks(),
                new IllegalDamage(),
                new BlockLogger(),
                new OtherPrevention(),
                new DamageManager(),
                new ShootingManager(),
                new MysticDamageExecutor(),
                new TEST()
        };
        for (Listener listener : listeners) Bukkit.getPluginManager().registerEvents(listener, Main.getInstance());
    }

    public static void registerCommands() {
        JavaPlugin mainInstance = (JavaPlugin) Main.getInstance();
        mainInstance.getCommand("spawn").setExecutor(new SpawnCommand());
        mainInstance.getCommand("giveprot").setExecutor(new GiveProtCommand());
        mainInstance.getCommand("pitenchant").setExecutor(new PitEnchantCommand());
        mainInstance.getCommand("giveallfresh").setExecutor(new GiveAllFreshCommand());
        mainInstance.getCommand("pitenchants").setExecutor(new PitEnchantsCommand());
    }

}
