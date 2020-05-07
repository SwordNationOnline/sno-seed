package br.com.nation.sdk.registry.humanoid;

import br.com.nation.api.prototype.humanoid.Humanoid;
import br.com.nation.api.repository.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HumanoidRepository implements Repository<UUID, Humanoid> {

    private final Map<UUID, Humanoid> humanoidMap = new ConcurrentHashMap<>();

    @Override
    public Map<UUID, Humanoid> getMap() {
        return humanoidMap;
    }

    @Override
    public void put(UUID key, Humanoid value) {
        humanoidMap.put(key, value);
    }

    @Override
    public void remove(UUID key, Humanoid value) {
        humanoidMap.remove(key, value);
    }

    @Override
    public Humanoid find(UUID key) {
        return humanoidMap.get(key);
    }

}
