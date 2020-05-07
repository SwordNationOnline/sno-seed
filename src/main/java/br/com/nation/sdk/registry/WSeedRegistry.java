package br.com.nation.sdk.registry;

import br.com.nation.api.group.Group;
import br.com.nation.api.manager.Manager;
import br.com.nation.api.profession.Profession;
import br.com.nation.api.prototype.humanoid.Humanoid;
import br.com.nation.api.registry.SeedRegistry;
import br.com.nation.api.repository.Repository;
import br.com.nation.sdk.registry.group.GroupManager;
import br.com.nation.sdk.registry.humanoid.HumanoidRepository;
import br.com.nation.sdk.registry.profission.ProfissionManager;

import java.util.UUID;

public class WSeedRegistry implements SeedRegistry {

    private final Manager<Profession, String> professionManager = new ProfissionManager();
    private final Manager<Group, String> groupManager = new GroupManager();
    private final Repository<UUID, Humanoid> humanoidRepository = new HumanoidRepository();

    @Override
    public Manager<Profession, String> getProfessions() {
        return professionManager;
    }

    @Override
    public Manager<Group, String> getGroups() {
        return groupManager;
    }

    @Override
    public Repository<UUID, Humanoid> getHumanoids() {
        return humanoidRepository;
    }

}
