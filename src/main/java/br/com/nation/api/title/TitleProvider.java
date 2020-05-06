package br.com.nation.api.title;

import br.com.nation.api.title.type.TitleType;
import org.bukkit.entity.Player;

public interface TitleProvider {

    void sendTitle(TitleType titleType, Player player, String message);

    void sendTitle(TitleType titleType, Player player, String message, String subTitle);

}
