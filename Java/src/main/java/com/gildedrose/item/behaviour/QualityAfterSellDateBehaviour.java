package com.gildedrose.item.behaviour;

import com.gildedrose.Item;
import com.sun.istack.internal.NotNull;

public interface QualityAfterSellDateBehaviour {
    void updateQualityAfterSelldate(@NotNull final Item item);
}
