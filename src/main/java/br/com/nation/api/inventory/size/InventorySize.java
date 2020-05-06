package br.com.nation.api.inventory.size;

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
}