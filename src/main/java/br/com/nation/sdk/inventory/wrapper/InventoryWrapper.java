package br.com.nation.sdk.inventory.wrapper;

import br.com.nation.sdk.inventory.InventorySustainer;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class InventoryWrapper implements InventoryHolder {

    private Inventory inventory;
    private final InventorySustainer sustainer;

    private HideService hideService;

    private ShowService showService;

    public InventoryWrapper(InventorySustainer sustainer) {
        this.sustainer = sustainer;
    }

    public InventorySustainer getSustainer() {
        return sustainer;
    }

    public void show(ShowService showService) {
        this.showService = showService;
    }

    public void hide(HideService hideService) {
        this.hideService = hideService;
    }

    public HideService getHide() {
        return hideService;
    }

    public ShowService getShow() {
        return showService;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public interface ShowService {

        void apply(InventoryOpenEvent event);

    }

    public interface HideService {

        void apply(InventoryCloseEvent event);

    }

}