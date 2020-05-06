package br.com.nation.sdk.title;

import br.com.nation.api.title.TitleProvider;
import br.com.nation.api.title.type.TitleType;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.Player;

public class WTitleProvider implements TitleProvider {

    @Override
    public void sendTitle(TitleType titleType, Player player, String message) {
        switch (titleType) {
            case TITLE:
                sendTitle(titleType, player, message, " "); break;
            case BOSS_BAR:
                Bukkit.createBossBar(message, BarColor.BLUE, BarStyle.SEGMENTED_10, BarFlag.DARKEN_SKY); break;
            case ACTION_BAR:
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder(message).create()); break;
        }
    }

    @Override
    public void sendTitle(TitleType titleType, Player player, String message, String subTitle) {
        switch (titleType) {
            case ACTION_BAR:
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder(message + " " + subTitle).create()); break;
            case BOSS_BAR:
                Bukkit.createBossBar(message + " " + subTitle, BarColor.BLUE, BarStyle.SEGMENTED_10); break;
            case TITLE:
                player.sendTitle(message, subTitle, 10, 10 ,10); break;
        }
    }



}
