package br.com.nation.api.nbt;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.TileEntity;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface NBTProvider {

    NBTTagCompound find(Entity entity);

    NBTTagCompound find(ItemStack itemStack);

    TileEntity find(Block block);

}
