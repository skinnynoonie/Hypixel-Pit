package me.skinnynoonie.hypixelpit.mysticfacility.mysticenchants.bows;

import me.skinnynoonie.hypixelpit.managers.CooldownManager;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.FreshMysticType;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticEnchant;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticInteractionType;
import me.skinnynoonie.hypixelpit.utils.MessageUtils;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class MegaLongbow extends MysticEnchant {

    @Override
    public void execute(Event oldEvent, byte tier) {
        EntityShootBowEvent event = (EntityShootBowEvent) oldEvent;
        Player player = (Player) event.getEntity();
        if(CooldownManager.getTimeSinceCooldown(player, "megalongbow") < 1000) return;
        event.getProjectile().setVelocity(event.getProjectile().getVelocity().normalize().multiply(3));
        ((Arrow) event.getProjectile()).setCritical(true);
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, tier), true);
        CooldownManager.setCooldown(player, "megalongbow");
    }

    @Override
    public FreshMysticType getType() {
        return FreshMysticType.BOW;
    }

    @Override
    public List<String> getDescription(byte tier) {
        if(tier == 3) return new ArrayList<>(MessageUtils.translateTexts(
                "&7One shot per second, this bow is",
                "&7automatically fully drawn and",
                "&7grants &aJump Boost IV &7(2s)"
        ));
        if(tier == 2) return new ArrayList<>(MessageUtils.translateTexts(
                "&7One shot per second, this bow is",
                "&7automatically fully drawn and",
                "&7grants &aJump Boost III &7(2s)"
        ));
        return new ArrayList<>(MessageUtils.translateTexts(
                "&7One shot per second, this bow is",
                "&7automatically fully drawn and",
                "&7grants &aJump Boost II &7(2s)"
        ));
    }

    @Override
    public String getReferenceName() {
        return "megalongbow";
    }

    @Override
    public String getDisplayName() {
        return MessageUtils.translate("&dRARE! &9Mega Longbow ");
    }

    @Override
    public MysticInteractionType getEventType() {
        return MysticInteractionType.ShooterShootBow;
    }
}
