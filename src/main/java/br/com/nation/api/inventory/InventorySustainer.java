package br.com.nation.api.inventory;

import br.com.nation.api.inventory.size.InventorySize;
import br.com.nation.api.inventory.wrapper.InventoryWrapper;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public abstract class InventorySustainer {

    private final ItemStack[] itemStacks;
    private final InteractService[] interactServices;
    private final String nameInventory;
    private final InventorySize inventorySize;
    private final InventoryWrapper inventoryWrapper;

    public InventorySustainer(String nameInventory, InventorySize inventorySize) {
        this.nameInventory = nameInventory; this.inventorySize = inventorySize;

        itemStacks = new ItemStack[inventorySize.getSlots()];
        interactServices = new InteractService[inventorySize.getSlots()];
        inventoryWrapper = new InventoryWrapper(this);
    }

    public ItemStack[] getStacks() {
        return itemStacks;
    }

    public InteractService[] getServices() {
        return interactServices;
    }

    public interface InteractService {
        void apply(InventoryClickEvent event);
    }

    public void setItem(int slot, ItemStack itemStack, InteractService interactService) {
        interactServices[slot] = interactService; itemStacks[slot] = itemStack;
    }

    public void setItem(int slot, ItemStack itemStack) {
        setItem(slot, itemStack, null);
    }

    public static void register(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(new Listener() {

            @EventHandler(priority = EventPriority.LOW)
            private void onInteract(InventoryClickEvent event) {
                Inventory inventory = event.getClickedInventory();

                if(!(inventory.getHolder() instanceof InventoryWrapper)) return;

                event.setCancelled(true); int rawSlot = event.getRawSlot();

                InventoryWrapper wrapper = (InventoryWrapper) inventory.getHolder();

                InteractService interactService = wrapper.getSustainer().getServices()[rawSlot];

                if(interactService == null) return;

                interactService.apply(event);
            }
        }, plugin);
    }

    public void apply(Player player) {
        Inventory inventory = Bukkit.createInventory(inventoryWrapper, inventorySize.getSlots(), nameInventory);

        inventoryWrapper.setInventory(inventory);

        for (int i = 0; i!=itemStacks.length; i++) if (itemStacks[i] != null) inventory.setItem(i, itemStacks[i]);

        player.openInventory(inventory);
    }

}
