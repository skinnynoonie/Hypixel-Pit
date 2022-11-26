package me.skinnynoonie.hypixelpit.prevention;

import me.skinnynoonie.hypixelpit.loggers.BlockLogger;
import me.skinnynoonie.hypixelpit.utils.MapUtils;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class IllegalBlocks implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if(player.getGameMode() == GameMode.CREATIVE) return;

        Location blockLoc = event.getBlock().getLocation();
        if(MapUtils.isInSpawn(blockLoc)) event.setCancelled(true);

    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if(player.getGameMode() == GameMode.CREATIVE) return;

        Block block = event.getBlock();
        if(!BlockLogger.isLogged(block)) event.setCancelled(true);

    }

}
