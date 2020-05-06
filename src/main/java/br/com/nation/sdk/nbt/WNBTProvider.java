package br.com.nation.sdk.nbt;

import br.com.nation.api.nbt.NBTProvider;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.TileEntity;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

public class WNBTProvider implements NBTProvider {

    @Override
    public NBTTagCompound find(Entity entity) {
        net.minecraft.server.v1_12_R1.Entity craftEntity = ((CraftEntity) entity).getHandle();

        NBTTagCompound nbtTagCompound = new NBTTagCompound(); craftEntity.f(nbtTagCompound);

        return nbtTagCompound;
    }

    @Override
    public NBTTagCompound find(ItemStack itemStack) {
        net.minecraft.server.v1_12_R1.ItemStack craftItem = CraftItemStack.asNMSCopy(itemStack);

        return craftItem.hasTag() ? craftItem.getTag() : new NBTTagCompound();
    }

    @Override
    public TileEntity find(Block block) {
        CraftWorld craftWorld = (CraftWorld) block.getWorld();

        return craftWorld.getTileEntityAt(block.getX(), block.getY(), block.getZ());
    }
}
