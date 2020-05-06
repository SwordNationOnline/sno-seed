package br.com.nation.api.profession;

import br.com.nation.api.profession.ability.Ability;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public abstract class Profession {

    public abstract String getName();

    public abstract List<Ability> getAbilitys();

    public abstract ItemStack getIcon();

}
