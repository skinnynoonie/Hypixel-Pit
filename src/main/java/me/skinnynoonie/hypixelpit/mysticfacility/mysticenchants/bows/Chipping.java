package me.skinnynoonie.hypixelpit.mysticfacility.mysticenchants.bows;

import me.skinnynoonie.hypixelpit.mysticfacility.properties.FreshMysticType;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticEnchant;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticInteractionType;
import me.skinnynoonie.hypixelpit.utils.DamageUtils;
import me.skinnynoonie.hypixelpit.utils.EventUtils;
import me.skinnynoonie.hypixelpit.utils.MessageUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;
import java.util.List;

public class Chipping extends MysticEnchant {

    @Override
    public void execute(Event oldEvent, byte tier) {
        EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) oldEvent;
        DamageUtils.dealTrueDamage((Player) event.getEntity(), EventUtils.getAttackerFromEDE(event), tier);
    }

    @Override
    public FreshMysticType getType() {
        return FreshMysticType.BOW;
    }

    @Override
    public List<String> getDescription(byte tier) {
        if(tier == 3) return new ArrayList<>(MessageUtils.translateTexts(
                "&7Deals &c1.5❤ &7extra true damage"
        ));
        if(tier == 2) return new ArrayList<>(MessageUtils.translateTexts(
                "&7Deals &c1.0❤ &7extra true damage"
        ));
        return new ArrayList<>(MessageUtils.translateTexts(
                "&7Deals &c0.5❤ &7extra true damage"
        ));
    }

    @Override
    public String getReferenceName() {
        return "chipping";
    }

    @Override
    public String getDisplayName() {
        return MessageUtils.translate("&9Chipping ");
    }

    @Override
    public MysticInteractionType getEventType() {
        return MysticInteractionType.VictimDamageByArrow;
    }
}
