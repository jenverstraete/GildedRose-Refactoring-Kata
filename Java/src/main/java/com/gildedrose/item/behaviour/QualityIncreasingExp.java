package com.gildedrose.item.behaviour;

import com.gildedrose.Item;
import com.sun.istack.internal.NotNull;

public class QualityIncreasingExp implements QualityBehaviour {
    @Override
    public void updateQuality(final Item item) {
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

    private void incrementItemQuality(@NotNull final Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
