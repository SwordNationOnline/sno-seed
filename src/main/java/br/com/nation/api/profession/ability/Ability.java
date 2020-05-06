package br.com.nation.api.profession.ability;

import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public interface Ability {

    String getName();

    Listener getListener();

    AbilityType getType();

    ItemStack getIcon();

    enum AbilityType {
        PACIFIC,
        NEUTRAL,
        AGGRESSIVE,
    }

}
