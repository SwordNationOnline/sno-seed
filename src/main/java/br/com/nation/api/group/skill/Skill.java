package br.com.nation.api.group.skill;

import br.com.nation.api.prototype.humanoid.Humanoid;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public interface Skill {

    String getName();

    ItemStack getIcon();

    long getCooldown();

    Consumer<Humanoid> onApply();

}
