package com.gildedrose;

import com.gildedrose.item.RegularItem;

class UpdateQualityService {
    void updateItemQuality(final RegularItem item) {
        item.updateQuality();
    }

    void decreaseSellInDate(final RegularItem item) {
        item.updateSellDate();
    }

    void updateQualityPastSellDate(final RegularItem item) {
        item.updateQualityAfterDeadline();
    }
}
