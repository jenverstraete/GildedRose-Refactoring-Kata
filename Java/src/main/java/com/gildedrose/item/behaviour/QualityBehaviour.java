package com.gildedrose.item.behaviour;

import com.gildedrose.Item;
import com.sun.istack.internal.NotNull;

public interface QualityBehaviour {
    void updateQuality(@NotNull final Item item);
}
