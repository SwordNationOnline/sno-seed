package br.com.nation.api.modded;

import br.com.nation.api.prototype.humanoid.Humanoid;
import org.bukkit.entity.Player;

import java.io.File;

public interface ModdedProvider {

    File getDabatase();

    Humanoid find(Player player);

    Humanoid save(Player player);

}
