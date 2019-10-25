package com.gildedrose;

class GildedRose {
    NewItem[] items;
    private final UpdateQualityService updateQualityService;

    GildedRose(NewItem[] items) {
        this.items = items;
        updateQualityService = new UpdateQualityService();
    }

    void updateQuality() {
        for (final NewItem item : items) {
            updateQualityService.updateItemQuality(item);
            updateQualityService.decreaseSellInDate(item);
            updateQualityService.updateQualityPastSellDate(item);
        }
    }
}