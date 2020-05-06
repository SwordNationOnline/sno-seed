package br.com.nation.api.entity;

import br.com.nation.api.entity.trait.TraitCommon;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Location;

import java.util.function.Function;

public abstract class NPCSustainer {

    public abstract TraitCommon getTrait();

    public abstract Function<Location, NPC> onCall();

}
