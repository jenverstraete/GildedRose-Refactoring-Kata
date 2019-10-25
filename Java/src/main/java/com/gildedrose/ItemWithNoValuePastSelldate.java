package com.gildedrose;

import com.sun.istack.internal.NotNull;

public class ItemWithNoValuePastSelldate extends NewItem {
    ItemWithNoValuePastSelldate(final String name, final int sellIn, final int quality, final boolean isSellable) {
        super(name, sellIn, quality, isSellable);
    }

    void incrementItemQuality(@NotNull final Item item) {
        if (item.sellIn < 11) {
            incrementItemQuality(item);
        }

        if (item.sellIn < 6) {
            incrementItemQuality(item);
        }
    }
}
