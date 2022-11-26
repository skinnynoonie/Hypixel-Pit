package me.skinnynoonie.hypixelpit.mysticfacility.mysticenchants.swords;

import me.skinnynoonie.hypixelpit.mysticfacility.properties.FreshMysticType;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticEnchant;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticInteractionType;
import me.skinnynoonie.hypixelpit.utils.MessageUtils;
import org.bukkit.event.Event;

import java.util.ArrayList;
import java.util.List;

public class ComboPerunsWrath extends MysticEnchant {
    @Override
    public void execute(Event oldEvent, byte tier) {

    }

    @Override
    public FreshMysticType getType() {
        return FreshMysticType.SWORD;
    }

    @Override
    public List<String> getDescription(byte tier) {
        if(tier == 3) return new ArrayList<>(MessageUtils.translateTexts(
                "&7Every &efourth &7hit strikes",
                "&elightning&7 for &c1❤ &7+&c 1❤",
                "&7per &bdiamond piece&7 on your",
                "&7victim.",
                "&7&oLightning deals true damage"
        ));
        if(tier == 2) return new ArrayList<>(MessageUtils.translateTexts(
                "&7Every &efourth &7hit strikes",
                "&elightning&7 for 2❤&7.",
                "&7&oLightning deals true damage"
        ));
        return new ArrayList<>(MessageUtils.translateTexts(
                "&7Every &efifth &7hit strikes",
                "&elightning&7 for 1.5❤&7.",
                "&7&oLightning deals true damage"
        ));
    }

    @Override
    public String getReferenceName() {
        return "comboperunswrath";
    }

    @Override
    public String getDisplayName() {
        return MessageUtils.translate( "&dRARE! &9Combo: Perun's Wrath ");
    }

    @Override
    public MysticInteractionType getEventType() {
        return MysticInteractionType.AttackerHitVictim;
    }
}
