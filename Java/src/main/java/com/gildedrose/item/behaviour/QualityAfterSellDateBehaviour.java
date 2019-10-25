package com.gildedrose.item.behaviour;

import com.gildedrose.item.ItemImpl;
import com.sun.istack.internal.NotNull;

public interface QualityAfterSellDateBehaviour {
    void updateQualityAfterSelldate(@NotNull final ItemImpl item);
}
