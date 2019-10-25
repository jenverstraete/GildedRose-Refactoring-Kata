package com.gildedrose;

import com.sun.istack.internal.NotNull;

class NewItem extends Item {
    NewItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    void decrementItemQuality(@NotNull final Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    void incrementItemQuality(@NotNull final Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
