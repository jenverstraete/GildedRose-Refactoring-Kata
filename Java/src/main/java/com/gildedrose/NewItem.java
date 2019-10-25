package com.gildedrose;

class NewItem extends Item {
    private final boolean sellable;

    NewItem(final String name, final int sellIn, final int quality, final boolean sellable) {
        super(name, sellIn, quality);
        this.sellable = sellable;
    }

    boolean isSellable() {
        return sellable;
    }
}
