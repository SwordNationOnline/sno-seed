package br.com.nation.sdk.inventory.size;

public enum InventorySize {
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

    public static InventorySize fromSlot(int slot) {
        for(InventorySize inventorySize : values()) {
            if(inventorySize.getSlots() == slot) {
                return inventorySize;
            }
        } return null;
    }

}