package br.com.nation;

import br.com.nation.api.SeedAPI;
import br.com.nation.sdk.WSeedAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public final class SAOSeed extends JavaPlugin {

    public static SAOSeed getInstance() {
        return getPlugin(SAOSeed.class);
    }

    private final SeedAPI seedAPI = new WSeedAPI();

    @Override
    public void onEnable() {
        Bukkit.getServicesManager().register(SeedAPI.class, seedAPI, this, ServicePriority.Lowest);
    }



    @Override
    public void onDisable() {
    }
}
