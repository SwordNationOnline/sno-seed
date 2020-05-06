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

    @Override
    public JSONProvider getJSONProvider() {
        return JSONProvider.getInstance();
    }

    @Override
    public TitleProvider getTitleProvider() {
        return WTitleProvider.getInstance();
    }

    @Override
    public NBTProvider getNBTProvider() {
        return WNBTProvider.getInstance();
    }

    @Override
    public SeedRegistry getRegistry() {
        return WSeedRegistry.getInstance();
    }
}
