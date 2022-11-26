package me.skinnynoonie.hypixelpit.prevention;

import me.skinnynoonie.hypixelpit.utils.MapUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class OtherPrevention implements Listener {

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        event.setFoodLevel(20);
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event) {
        if(event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL) event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onShoot(EntityShootBowEvent event) {
        if(MapUtils.isInSpawn(event.getEntity().getLocation())) event.setCancelled(true);
    }

}
