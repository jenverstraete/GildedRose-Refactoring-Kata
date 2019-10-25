package com.gildedrose.item.behaviour;

import com.gildedrose.Item;
import com.sun.istack.internal.NotNull;

public class QualityAfterSellDateIncreasing implements QualityAfterSellDateBehaviour {
    @Override
    public void updateQualityAfterSelldate(@NotNull final Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
