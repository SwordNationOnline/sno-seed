package br.com.nation.api.entity;

import br.com.nation.api.entity.trait.TraitCommon;
import org.bukkit.Location;
import org.bukkit.entity.NPC;

import java.util.function.Function;

public abstract class NPCSustainer {

    public abstract String getName();

    public abstract TraitCommon getTrait();

    public abstract Function<Location, NPC> onCall();

}
