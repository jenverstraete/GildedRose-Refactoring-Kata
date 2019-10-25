package com.gildedrose;

import com.gildedrose.item.RegularItem;

class GildedRose {
    RegularItem[] items;
    private final UpdateQualityService updateQualityService;

    GildedRose(RegularItem[] items) {
        this.items = items;
        updateQualityService = new UpdateQualityService();
    }

    void updateQuality() {
        for (final RegularItem item : items) {
            updateQualityService.updateItemQuality(item);
            updateQualityService.decreaseSellInDate(item);
            updateQualityService.updateQualityPastSellDate(item);
        }
    }
}