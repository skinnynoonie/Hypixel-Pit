package me.skinnynoonie.hypixelpit.mysticfacility.mysticenchants.swords;

import me.skinnynoonie.hypixelpit.mysticfacility.properties.FreshMysticType;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticEnchant;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticInteractionType;
import me.skinnynoonie.hypixelpit.utils.MessageUtils;
import me.skinnynoonie.hypixelpit.utils.PlayerUtils;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;
import java.util.List;

public class BulletTime extends MysticEnchant {
    @Override
    public void execute(Event oldEvent, byte tier) {
        EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) oldEvent;
        Player victim = (Player) event.getEntity();
        if(!victim.isBlocking()) return;
        Entity projectile = event.getDamager();
        projectile.remove();
        event.setCancelled(true);
        victim.getWorld().playSound(victim.getEyeLocation(), Sound.FIZZ, 1,1.5f);
        victim.getWorld().playEffect(victim.getEyeLocation(), Effect.EXPLOSION, 0, 30);
        if(tier == 3) PlayerUtils.heal(victim, 3);
        if(tier == 2) PlayerUtils.heal(victim, 2);
        if(tier == 1) PlayerUtils.heal(victim, 0);
    }

    @Override
    public FreshMysticType getType() {
        return FreshMysticType.SWORD;
    }

    @Override
    public List<String> getDescription(byte tier) {
        if(tier == 3) return new ArrayList<>(MessageUtils.translateTexts(
                "&7Block destroys arrows hitting",
                "&7you. Destroying arrows this way",
                "&7heals &c1.5❤"
        ));
        if(tier == 2) return new ArrayList<>(MessageUtils.translateTexts(
                "&7Block destroys arrows hitting",
                "&7you. Destroying arrows this way",
                "&7heals &c1❤"
        ));
        return new ArrayList<>(MessageUtils.translateTexts(
                "&7Block destroys arrows that hit",
                "&7you"
        ));
    }

    @Override
    public String getReferenceName() {
        return "bullettime";
    }

    @Override
    public String getDisplayName() {
        return MessageUtils.translate("&9Bullet Time ");
    }

    @Override
    public MysticInteractionType getEventType() {
        return MysticInteractionType.VictimHoldSwordWhenDamaged;
    }
}
