package com.gildedrose;

import com.sun.istack.internal.NotNull;

class UpdateQualityService {
    void updateItemQuality(final NewItem item) {
        if (item.name.equals("Aged Brie")
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            improveItemQuality(item);
        } else {
            decrementItemQuality(item);
        }
    }

    private void improveItemQuality(final NewItem item) {
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

    private void decrementItemQuality(@NotNull final NewItem item) {
        if (item.isSellable() && item.quality > 0) {
            item.quality--;
        }
    }

    private void incrementItemQuality(@NotNull final Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    void decreaseSellInDate(final NewItem item) {
        if (item.isSellable()) {
            item.sellIn = item.sellIn - 1;
        }
    }

    void updateQualityPastSellDate(final NewItem item) {
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
        decrementItemQuality(item);
    }
}
