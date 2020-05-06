package br.com.nation.sdk.inventory.wrapper;

import br.com.nation.sdk.inventory.InventorySustainer;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class InventoryWrapper implements InventoryHolder {

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

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}