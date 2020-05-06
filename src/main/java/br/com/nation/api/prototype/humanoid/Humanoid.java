package br.com.nation.api.prototype.humanoid;

import br.com.nation.api.group.Group;
import br.com.nation.api.profession.Profession;
import br.com.nation.api.prototype.Prototype;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface Humanoid extends Prototype<UUID> {

    Player getPlayer();

    Group getGroup();

    Profession getProfession();

    int getLevel();

    long getExperience();

    void setLevel(int level);

    void setExperience(long experience);

}
