package br.com.nation.api.entity.trait;

import br.com.nation.api.entity.NPCSustainer;
import net.citizensnpcs.api.event.NPCClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.trait.Trait;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public abstract class TraitCommon extends Trait {
    public TraitCommon(NPCSustainer npcSustainer) {
        super(npcSustainer.toString());
    }

    protected interface ClickService {

        void apply(NPCClickEvent event);

    }

    public abstract ClickService getClickService();

    public static void register(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(new Listener() {

            @EventHandler(priority = EventPriority.LOW)
            private void onClick(NPCClickEvent event) {
                NPC npc = event.getNPC();

                if(npc.hasTrait(TraitCommon.class)) return;

                npc.getTrait(TraitCommon.class).getClickService().apply(event);
            }
        }, plugin);
    }

}
