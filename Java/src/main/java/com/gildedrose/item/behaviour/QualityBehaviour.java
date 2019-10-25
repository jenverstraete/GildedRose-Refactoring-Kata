package com.gildedrose.item.behaviour;

import com.gildedrose.item.ItemImpl;
import com.sun.istack.internal.NotNull;

public interface QualityBehaviour {
    void updateQuality(@NotNull final ItemImpl item);
}
