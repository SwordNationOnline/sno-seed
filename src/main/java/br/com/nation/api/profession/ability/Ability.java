package br.com.nation.api.profession.ability;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public interface Ability {

    String getName();

    Listener getListener();

    ItemStack getIcon();

    Consumer<Player> onApply();

}
