package br.com.nation.api;

import br.com.nation.api.nbt.NBTProvider;
import br.com.nation.api.registry.SeedRegistry;
import br.com.nation.api.title.TitleProvider;
import br.com.nation.sdk.database.DatabaseProvider;
import br.com.nation.sdk.json.JSONProvider;

public interface SeedAPI {

    JSONProvider getJSONProvider();

    TitleProvider getTitleProvider();

    NBTProvider getNBTProvider();

    SeedRegistry getRegistry();

    DatabaseProvider getDatabaseProvider();

}
