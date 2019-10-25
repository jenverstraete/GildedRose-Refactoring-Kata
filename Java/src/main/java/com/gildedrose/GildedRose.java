package com.gildedrose;

class GildedRose {
    NewItem[] items;

    GildedRose(NewItem[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (final NewItem item : items) {
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

    private void updateItemQuality(final NewItem item) {
        if (item.name.equals("Aged Brie")
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            improveItemQuality(item);
        } else {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.decrementItemQuality(item);
            }
        }
    }

    private void updateQualityOfItemsPastSellDate(final NewItem item) {
        if (item.sellIn >= 0) {
            return;
        }
        if (item.name.equals("Aged Brie")) {
            item.incrementItemQuality(item);
            return;
        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
            return;
        }
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.decrementItemQuality(item);
        }
    }

    private void improveItemQuality(final NewItem item) {
        item.incrementItemQuality(item);

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 11) {
                item.incrementItemQuality(item);
            }

            if (item.sellIn < 6) {
                item.incrementItemQuality(item);
            }
        }
    }
}