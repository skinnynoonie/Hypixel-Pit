package me.skinnynoonie.hypixelpit.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.Random;

public class MapUtils {

    public static boolean isInSpawn(Location location) {
        double xCoord = location.getX();
        double yCoord = location.getY();
        double zCoord = location.getZ();

        if(xCoord < -23.5 || xCoord > 24.5) return false;
        if(yCoord < 93) return false;
        if(zCoord < -23.5 || zCoord > 24.5) return false;

        return true;
    }

    public static Location getRandomSpawnLocation() {
        ArrayList<Location> spawnLocations = new ArrayList<>();
        spawnLocations.add(
                new Location(Bukkit.getWorld("world"), 0.4, 95, 10.5, 180, 0)
        );

        int listSize = spawnLocations.size();
        int randomNumber = new Random().nextInt(listSize);

        return spawnLocations.get(randomNumber);
    }

}
