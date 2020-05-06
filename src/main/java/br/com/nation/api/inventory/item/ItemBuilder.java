package br.com.nation.api.inventory.item;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.function.Consumer;

public abstract class ItemBuilder {

    public abstract ItemStack build();

    protected abstract ItemBuilder applyMeta(Consumer<ItemMeta> consumer);

    protected abstract ItemBuilder applyStack(Consumer<ItemStack> consumer);

    public abstract ItemBuilder name(String name);

    public abstract ItemBuilder lore(String... strings);

}
