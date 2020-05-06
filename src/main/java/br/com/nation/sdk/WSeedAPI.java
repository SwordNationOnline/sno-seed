package br.com.nation.sdk;

import br.com.nation.api.SeedAPI;
import br.com.nation.api.nbt.NBTProvider;
import br.com.nation.api.registry.SeedRegistry;
import br.com.nation.api.title.TitleProvider;
import br.com.nation.sdk.json.JSONProvider;
import br.com.nation.sdk.nbt.WNBTProvider;
import br.com.nation.sdk.registry.WSeedRegistry;
import br.com.nation.sdk.title.WTitleProvider;

public class WSeedAPI implements SeedAPI {

    private final JSONProvider jsonProvider = new JSONProvider();
    private final TitleProvider wTitleProvider = new WTitleProvider();
    private final NBTProvider nbtProvider = new WNBTProvider();
    private final SeedRegistry seedRegistry = new WSeedRegistry();

    @Override
    public JSONProvider getJSONProvider() {
        return jsonProvider;
    }

    @Override
    public TitleProvider getTitleProvider() {
        return wTitleProvider;
    }

    @Override
    public NBTProvider getNBTProvider() {
        return nbtProvider;
    }

    @Override
    public SeedRegistry getRegistry() {
        return seedRegistry;
    }
}
