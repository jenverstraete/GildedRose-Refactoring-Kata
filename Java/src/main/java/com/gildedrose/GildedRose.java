package com.gildedrose;

import com.gildedrose.item.ItemImpl;

class GildedRose {
    ItemImpl[] items;

    GildedRose(ItemImpl[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (final ItemImpl item : items) {
            item.updateQuality();
            item.updateSellDate();
            item.updateQualityAfterDeadline();
        }
    }
}