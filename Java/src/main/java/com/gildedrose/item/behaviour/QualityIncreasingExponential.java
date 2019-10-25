package com.gildedrose.item.behaviour;

import com.gildedrose.item.ItemImpl;
import com.sun.istack.internal.NotNull;

public class QualityIncreasingExponential implements QualityBehaviour {
    @Override
    public void updateQuality(@NotNull final ItemImpl item) {
        item.incrementQuality();
        if (item.sellIn < 11) {
            item.incrementQuality();
        }
        if (item.sellIn < 6) {
            item.incrementQuality();
        }
    }
}
