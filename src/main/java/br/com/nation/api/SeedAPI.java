package br.com.nation.api;

import br.com.nation.api.nbt.NBTProvider;
import br.com.nation.api.title.TitleProvider;
import br.com.nation.sdk.json.JSONProvider;

public interface SeedAPI {

    JSONProvider getJSONProvider();

    TitleProvider getTitleProvider();

    NBTProvider getNBTProvider();

}
