package br.com.nation;

import br.com.nation.api.SeedAPI;
import br.com.nation.sdk.WSeedAPI;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public final class SAOSeed extends JavaPlugin {

    @Getter private final SeedAPI seedAPI = new WSeedAPI();
    private final String[] message = {
            " ",
            " ============================== ",
            "  §bSemente inicializada com sucesso!",
            "  §bTodos os prototipos foram adaptados.",
            " ============================== ",
            " "
    };

    public static SAOSeed getInstance() {
        return getPlugin(SAOSeed.class);
    }

    @Override
    public void onEnable() {
        Bukkit.getServicesManager().register(SeedAPI.class, seedAPI, this, ServicePriority.Lowest);

        seedAPI.getRegistry().getGroups().getList().forEach(group -> Bukkit.getPluginManager().registerEvents(group.getListener(), this));
        seedAPI.getRegistry().getProfessions().getList().forEach(profession -> profession.getAbilitys().forEach(ability -> Bukkit.getPluginManager().registerEvents(ability.getListener(), this)));
        if (!seedAPI.getDatabaseProvider().setup()) {
            Bukkit.getPluginManager().disablePlugin(this);
            Bukkit.broadcastMessage("A conexão com os bancos de dados falharam! O plugin esá sendo desabilitado.");
            return;
        }

        for (String message : message) {
            Bukkit.broadcastMessage(message);
        }
    }

    @Override
    public void onDisable() {

    }

}
