package br.com.nation.api.entity;

import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.trait.Trait;
import org.bukkit.Location;

import java.util.function.Function;

public abstract class NPCSustainer {

    public abstract Trait getTrait();

    public abstract Function<Location, NPC> onCall();

}
