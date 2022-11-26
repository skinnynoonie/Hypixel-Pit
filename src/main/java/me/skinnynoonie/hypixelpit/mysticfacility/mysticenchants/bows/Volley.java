package me.skinnynoonie.hypixelpit.mysticfacility.mysticenchants.bows;

import me.skinnynoonie.hypixelpit.Main;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.FreshMysticType;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticEnchant;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticInteractionType;
import me.skinnynoonie.hypixelpit.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Volley extends MysticEnchant {
    @Override
    public void execute(Event oldEvent, byte tier) {
        EntityShootBowEvent event = (EntityShootBowEvent) oldEvent;
        Player player = (Player) event.getEntity();
        AtomicReference<Vector> arrowVelocity = new AtomicReference<>();
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
            arrowVelocity.set(event.getProjectile().getVelocity());
            }, 1);
        for(int i = 1; i < tier + 2; i++)
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                player.launchProjectile(Arrow.class, arrowVelocity.get());
                player.getWorld().playSound(player.getLocation(), Sound.SHOOT_ARROW, 1, 0.75f);
            }, i*2);
    }

    @Override
    public FreshMysticType getType() {
        return FreshMysticType.BOW;
    }

    @Override
    public List<String> getDescription(byte tier) {
        if(tier == 3) return new ArrayList<>(MessageUtils.translateTexts(
                "&7Shoot &f5 arrows &7at once"
        ));
        if(tier == 2) return new ArrayList<>(MessageUtils.translateTexts(
                "&7Shoot &f4 arrows &7at once"
        ));
        return new ArrayList<>(MessageUtils.translateTexts(
                "&7Shoot &f3 arrows &7at once"
        ));
    }

    @Override
    public String getReferenceName() {
        return "volley";
    }

    @Override
    public String getDisplayName() {
        return MessageUtils.translate("&dRARE! &9Volley ");
    }

    @Override
    public MysticInteractionType getEventType() {
        return MysticInteractionType.ShooterShootBow;
    }
}
