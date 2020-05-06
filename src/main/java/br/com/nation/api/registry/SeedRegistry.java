package br.com.nation.api.registry;

import br.com.nation.api.group.Group;
import br.com.nation.api.manager.Manager;
import br.com.nation.api.profession.Profession;
import br.com.nation.api.prototype.humanoid.Humanoid;
import br.com.nation.api.repository.Repository;

import java.util.UUID;

public interface SeedRegistry {

    Manager<Profession, String> getProfessions();

    Manager<Group, String> getGroups();

    Repository<UUID, Humanoid> getHumanoids();

}
