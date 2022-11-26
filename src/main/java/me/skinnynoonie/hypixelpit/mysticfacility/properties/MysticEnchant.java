package me.skinnynoonie.hypixelpit.mysticfacility.properties;

import org.bukkit.event.Event;

import java.util.List;

public abstract class MysticEnchant {

    public abstract void execute(Event oldEvent, byte tier);

    public abstract FreshMysticType getType();

    public abstract List<String> getDescription(byte tier);

    public abstract String getReferenceName();

    public abstract String getDisplayName();

    public abstract MysticInteractionType getEventType();

}
