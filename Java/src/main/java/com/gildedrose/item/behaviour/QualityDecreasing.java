package com.gildedrose.item.behaviour;

import com.gildedrose.item.ItemImpl;
import com.sun.istack.internal.NotNull;

public class QualityDecreasing implements QualityBehaviour {
    @Override
    public void updateQuality(@NotNull final ItemImpl item) {
        item.decrementQuality();
    }
}
