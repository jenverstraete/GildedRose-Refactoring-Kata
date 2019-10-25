package com.gildedrose.item.behaviour;

import com.gildedrose.Item;
import com.sun.istack.internal.NotNull;

public class QualityDecreasing implements QualityBehaviour {
    @Override
    public void updateQuality(@NotNull final Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
