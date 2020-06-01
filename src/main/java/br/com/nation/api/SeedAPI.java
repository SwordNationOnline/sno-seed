package br.com.nation.api;

import br.com.nation.api.nbt.NBTProvider;
import br.com.nation.api.registry.SeedRegistry;
import br.com.nation.api.title.TitleProvider;

public interface SeedAPI {

    TitleProvider getTitleProvider();

    NBTProvider getNBTProvider();

    SeedRegistry getRegistry();

}
