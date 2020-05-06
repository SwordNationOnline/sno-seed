package br.com.nation.api.inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.List;

public abstract class InventorySustainer {

    public abstract List<Player> getViewers();

    public abstract String getTitle();

    public abstract InventorySize getSize();

    public abstract ItemStack[] getItems();

    public abstract InventoryWrapper getWrapper();

    public abstract InteractService[] getServices();

    enum InventorySize {
        ONE_LINE(9),
        TWO_LINES(18),
        THREE_LINES(27),
        FOUR_LINES(36),
        FIVE_LINES(45),
        SIX_LINES(54);

        private final Integer slots;

        InventorySize(Integer slots) {
            this.slots = slots;
        }

        public Integer getSlots() {
            return slots;
        }
    }

    class InventoryWrapper implements InventoryHolder {

        private Inventory inventory;
        private final InventorySustainer sustainer;

        public InventoryWrapper(InventorySustainer sustainer) {
            this.sustainer = sustainer;
        }

        public InventorySustainer getSustainer() {
            return sustainer;
        }

        @Override
        public Inventory getInventory() {
            return inventory;
        }
    }

    interface InteractService {
        void apply(InventoryClickEvent event);
    }

    public void setItem(int slot, ItemStack itemStack, InteractService interactService) {
        getServices()[slot] = interactService; getItems()[slot] = itemStack;
    }

    public void setItem(int slot, ItemStack itemStack) {
        setItem(slot, itemStack, null);
    }

    public abstract void apply(Player player);

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

}
