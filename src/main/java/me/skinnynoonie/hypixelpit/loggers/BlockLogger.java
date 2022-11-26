package me.skinnynoonie.hypixelpit.loggers;

import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.HashMap;
import java.util.Set;

public class BlockLogger implements Listener {

    private static final HashMap<Block, Boolean> loggedBlocks = new HashMap<>();

    public static boolean isLogged(Block block) {
        if(loggedBlocks.get(block) == null) return false;
        return true;
    }

    public static Set<Block> getLoggedBlocks() {
        return loggedBlocks.keySet();
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlace(BlockPlaceEvent event) {
        if(event.isCancelled()) return;
        if(event.getPlayer().getGameMode() == GameMode.CREATIVE) return;

        loggedBlocks.put(event.getBlock(), true);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBreak(BlockBreakEvent event) {
        loggedBlocks.remove(event.getBlock());
    }

}
