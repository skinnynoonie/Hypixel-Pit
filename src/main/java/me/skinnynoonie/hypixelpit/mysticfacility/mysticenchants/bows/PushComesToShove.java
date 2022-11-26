package me.skinnynoonie.hypixelpit.mysticfacility.mysticenchants.bows;

import me.skinnynoonie.hypixelpit.managers.ComboCounterManager;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.FreshMysticType;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticEnchant;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticInteractionType;
import me.skinnynoonie.hypixelpit.utils.EventUtils;
import me.skinnynoonie.hypixelpit.utils.MessageUtils;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class PushComesToShove extends MysticEnchant {

    @Override
    public void execute(Event oldEvent, byte tier) {
        EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) oldEvent;
        Player attacker = EventUtils.getAttackerFromEDE(event);
        ComboCounterManager.addCombo(attacker, "pushcomestoshove", 1);
        if(ComboCounterManager.getComboAmount(attacker, "pushcomestoshove") < 3) return;
        ((Arrow)event.getDamager()).setKnockbackStrength(3 + 2*(tier - 1));
        event.setDamage(event.getDamage() + tier - 1);
        ComboCounterManager.setCombo(attacker, "pushcomestoshove", 0);
    }

    @Override
    public FreshMysticType getType() {
        return FreshMysticType.BOW;
    }

    @Override
    public List<String> getDescription(byte tier) {
        if(tier == 3) return new ArrayList<>(MessageUtils.translateTexts(
                "&7Every 3rd shot on a player has",
                "&bPunch VII &7and deals &c+1.0❤",
                "&7extra damage"
        ));
        if(tier == 2) return new ArrayList<>(MessageUtils.translateTexts(
            "&7Every 3rd shot on a player has",
            "&bPunch V &7and deals &c+0.5❤",
            "&7extra damage"
        ));
        return new ArrayList<>(MessageUtils.translateTexts(
                "&7Every 3rd shot on a player has",
                "&bPunch III"
        ));
    }

    @Override
    public String getReferenceName() {
        return "pushcomestoshove";
    }

    @Override
    public String getDisplayName() {
        return MessageUtils.translate("&9Push comes to shove ");
    }

    @Override
    public MysticInteractionType getEventType() {
        return MysticInteractionType.VictimDamageByArrow;
    }
}
