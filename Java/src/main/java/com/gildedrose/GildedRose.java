package com.gildedrose;

import com.sun.istack.internal.NotNull;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (final Item item : items) {
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    decrementItemQuality(item);
                }
            } else {
                incrementItemQuality(item);

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        incrementItemQuality(item);
                    }

                    if (item.sellIn < 6) {
                        incrementItemQuality(item);
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn >= 0) {
                continue;
            }
            if (item.name.equals("Aged Brie")) {
                incrementItemQuality(item);
                continue;
            }
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = 0;
                continue;
            }
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                decrementItemQuality(item);
            }
        }
    }

    private void decrementItemQuality(@NotNull final Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void incrementItemQuality(@NotNull final Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}