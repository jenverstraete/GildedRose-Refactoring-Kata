package com.gildedrose.item.behaviour;

import com.gildedrose.Item;

public class QualityIncreasing implements QualityBehaviour {
    @Override
    public void updateQuality(final Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
