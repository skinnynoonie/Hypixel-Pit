package me.skinnynoonie.hypixelpit.visuals;

import org.bukkit.ChatColor;

public class DamageActionBar {

    String victimName;
    int victimHearts;
    int finalDamageHearts;
    int victimMaxHearts;

    public DamageActionBar(String victimName, double victimHealth, double finalDamage, double victimMaxHealth) {
        this.victimName = victimName;
        this.victimHearts = (int) Math.floor((victimHealth - finalDamage)/2.0);
        this.finalDamageHearts = (int) Math.ceil(finalDamage/2.0);
        this.victimMaxHearts = (int) Math.ceil(victimMaxHealth/2.0);
    }

    public String getOutput() {
        StringBuilder output = new StringBuilder(ChatColor.GRAY + victimName + " ");
        for(int i = 0; i < victimMaxHearts; i++)
            if(i <= victimHearts)
                output.append(ChatColor.DARK_RED + "❤");
            else if(i <= victimHearts + finalDamageHearts)
                output.append(ChatColor.RED + "❤");
            else
                output.append(ChatColor.BLACK + "❤");
        return output.toString();

    }

}
