package com.gildedrose;

class GildedRose {
    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }
            item.sellIn--;
            switch (item.name) {
                case "Aged Brie":
                    updateImprovingItemQuality(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateExpiringItemQuality(item);
                    break;
                case "Conjured":
                    updateRegularItemQuality(item, 2);
                    break;
                default:
                    updateRegularItemQuality(item);
                    break;
            }
        }
    }

    private void updateRegularItemQuality(Item item) {
        updateRegularItemQuality(item, 1);
    }

    private void updateRegularItemQuality(Item item, int rate) {
        decreaseQuality(item, rate);
        if (item.sellIn < 0) {
            decreaseQuality(item, rate);
        }
    }

    private void updateImprovingItemQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private static void updateExpiringItemQuality(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn < 5) {
            increaseQuality(item, 3);
        } else if (item.sellIn < 10) {
            increaseQuality(item, 2);
        } else {
            increaseQuality(item, 1);
        }
    }

    private static void increaseQuality(Item item) {
        increaseQuality(item, 1);
    }

    private static void increaseQuality(Item item, int amount) {
        while (amount > 0 && item.quality < MAX_QUALITY) {
            amount--;
            item.quality++;
        }
    }

    private static void decreaseQuality(Item item, int amount) {
        while (amount > 0 && item.quality > MIN_QUALITY) {
            amount--;
            item.quality--;
        }
    }
}
