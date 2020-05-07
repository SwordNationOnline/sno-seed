package br.com.nation.api.group.skill;

import br.com.nation.api.group.type.GroupType;
import br.com.nation.api.prototype.humanoid.Humanoid;
import org.bukkit.inventory.ItemStack;

import java.util.function.Function;

public interface Skill {

    GroupType getGroupType();

    SkillType getType();

    String getName();

    ItemStack getIcon();

    long getCooldown();

    Function<Humanoid, SkillService> getService();

    interface SkillService {

        void apply(Humanoid humanoid);

    }

    enum SkillType {
        DAMAGE,
        DEFENSE,
        ATTRIBUTE,
        TELEPORT,
        SPEED
    }

}
