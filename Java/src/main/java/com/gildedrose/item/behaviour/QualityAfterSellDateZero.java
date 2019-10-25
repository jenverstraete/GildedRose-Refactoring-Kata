package com.gildedrose.item.behaviour;

import com.gildedrose.Item;
import com.sun.istack.internal.NotNull;

public class QualityAfterSellDateZero implements QualityAfterSellDateBehaviour {
    @Override
    public void updateQualityAfterSelldate(@NotNull final Item item) {
        item.quality = 0;
    }
}
