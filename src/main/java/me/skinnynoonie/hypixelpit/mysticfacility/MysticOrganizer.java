package me.skinnynoonie.hypixelpit.mysticfacility;

import me.skinnynoonie.hypixelpit.mysticfacility.mysticenchants.bows.Chipping;
import me.skinnynoonie.hypixelpit.mysticfacility.mysticenchants.bows.MegaLongbow;
import me.skinnynoonie.hypixelpit.mysticfacility.mysticenchants.bows.PushComesToShove;
import me.skinnynoonie.hypixelpit.mysticfacility.mysticenchants.bows.Volley;
import me.skinnynoonie.hypixelpit.mysticfacility.mysticenchants.swords.BulletTime;
import me.skinnynoonie.hypixelpit.mysticfacility.properties.MysticEnchant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class MysticOrganizer {

    private static final HashMap<String, MysticEnchant> registeredMystics = new HashMap<>();

    public static void registerMysticEnchant(MysticEnchant enchant) {
        registeredMystics.put(enchant.getReferenceName(), enchant);
    }

    public static java.util.Set<String> getRegisteredMysticKeys() {
        return registeredMystics.keySet();
    }

    public static MysticEnchant getMystic(String referenceName) {
        return registeredMystics.get(referenceName);
    }

    public static void registerMysticEnchants() {
        List<MysticEnchant> enchants = new ArrayList<>(Arrays.asList(
                new MegaLongbow(),
                new Volley(),
                new Chipping(),
                new BulletTime(),
                new PushComesToShove()
        ));
        for(MysticEnchant enchant : enchants) registerMysticEnchant(enchant);
    }

}
