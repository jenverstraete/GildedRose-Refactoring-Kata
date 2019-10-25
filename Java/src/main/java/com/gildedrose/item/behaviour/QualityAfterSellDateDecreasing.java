package com.gildedrose.item.behaviour;

import com.gildedrose.item.ItemImpl;
import com.sun.istack.internal.NotNull;

public class QualityAfterSellDateDecreasing implements QualityAfterSellDateBehaviour {
    @Override
    public void updateQualityAfterSelldate(@NotNull final ItemImpl item) {
        item.decrementQuality();
    }
}
