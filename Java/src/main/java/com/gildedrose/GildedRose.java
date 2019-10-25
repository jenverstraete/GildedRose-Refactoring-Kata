package com.gildedrose;

import com.sun.istack.internal.NotNull;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (final Item item : items) {
            updateItemQuality(item);
            decrementNumberOfDaysToSell(item);
            updateQualityOfItemsPastSellDate(item);
        }
    }

    private void decrementNumberOfDaysToSell(final Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateItemQuality(final Item item) {
        if (item.name.equals("Aged Brie")
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            improveItemQuality(item);
        } else {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                decrementItemQuality(item);
            }
        }
    }

    private void updateQualityOfItemsPastSellDate(final Item item) {
        if (item.sellIn >= 0) {
            return;
        }
        if (item.name.equals("Aged Brie")) {
            incrementItemQuality(item);
            return;
        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
            return;
        }
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            decrementItemQuality(item);
        }
    }

    private void improveItemQuality(final Item item) {
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