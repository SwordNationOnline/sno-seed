package entity;

import br.com.nation.api.entity.NPCSustainer;
import br.com.nation.api.entity.trait.TraitCommon;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.trait.Trait;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.function.Function;

public class QuestNPC extends NPCSustainer {

    private final TraitCommon traitCommon = new TraitCommon(this);

    @Override
    public TraitCommon getTrait() {
        return traitCommon;
    }

    @Override
    public Function<Location, NPC> onCall() {
        return location -> {
            NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, "José");

            npc.addTrait(traitCommon);

            npc.spawn(location); return npc;
        };
    }

    private class TraitQuest extends TraitCommon {

        public TraitQuest(NPCSustainer sustainer) {
            super(sustainer);
        }

        @Override
        public void onSpawn() {
            npc.getEntity().getNearbyEntities(10, 10, 10).forEach(entity -> {
                if(entity instanceof Player) {
                    entity.sendMessage("§aO NPC NASCEU PORAKKKKKKKKKKKK");
                }
            });
        }
    }
}
