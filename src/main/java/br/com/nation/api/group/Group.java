package br.com.nation.api.group;

import br.com.nation.api.group.skill.Skill;
import br.com.nation.api.group.type.GroupType;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public abstract class Group {

    public abstract String getName();

    public abstract Listener getListener();

    public abstract ItemStack getIcon();

    public abstract List<Skill> getSkills();

    public abstract GroupType getParent();

}
