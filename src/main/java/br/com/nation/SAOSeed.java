package br.com.nation;

import br.com.nation.api.SeedAPI;
import br.com.nation.api.entity.trait.TraitCommon;
import br.com.nation.sdk.WSeedAPI;
import br.com.nation.sdk.inventory.InventorySustainer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public final class SAOSeed extends JavaPlugin {

    private final SeedAPI seedAPI = new WSeedAPI();

    public static SAOSeed getInstance() {
        return getPlugin(SAOSeed.class);
    }

    @Override
    public void onEnable() {
        Bukkit.getServicesManager().register(SeedAPI.class, seedAPI, this, ServicePriority.Lowest);

        seedAPI.getRegistry().getGroups().getList().forEach(group -> Bukkit.getPluginManager().registerEvents(group.getListener(), this));
        seedAPI.getRegistry().getProfessions().getList().forEach(profession -> profession.getAbilities().forEach(ability -> Bukkit.getPluginManager().registerEvents(ability.getListener(), this)));

        InventorySustainer.register(this);
        TraitCommon.register(this);
    }

    @Override
    public void onDisable() {

    }

}
