package me.skinnynoonie.hypixelpit;

import me.skinnynoonie.hypixelpit.loggers.BlockLogger;
import me.skinnynoonie.hypixelpit.managers.CmdListenerManager;
import me.skinnynoonie.hypixelpit.managers.GameruleManager;
import me.skinnynoonie.hypixelpit.managers.PitScoreboardManager;
import me.skinnynoonie.hypixelpit.mysticfacility.MysticOrganizer;
import me.skinnynoonie.hypixelpit.visuals.PlayerLevelDisplay;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    private static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;

        CmdListenerManager.registerListeners();
        CmdListenerManager.registerCommands();
        PlayerLevelDisplay.registerMainTeam();
        GameruleManager.registerGamerules(Bukkit.getWorld("world"));
        MysticOrganizer.registerMysticEnchants();

        PitScoreboardManager.startScoreboardUpdating();
        for(Player player : Bukkit.getOnlinePlayers()) Bukkit.getServer().getPluginManager().callEvent(new PlayerJoinEvent(player, ""));
        clearEntities();
    }

    @Override
    public void onDisable() {
        PlayerLevelDisplay.unregisterMainTeam();
        for(Block block : BlockLogger.getLoggedBlocks()) block.setType(Material.AIR);
    }

    public static Plugin getInstance() {
        return instance;
    }

    public void clearEntities() {
        Bukkit.getScheduler().runTaskLater(this, () -> {
            for(LivingEntity entity : Bukkit.getWorld("world").getLivingEntities())
                if(entity.getType() != EntityType.PLAYER)
                    entity.damage(999999999);
        }, 20);
    }

}
