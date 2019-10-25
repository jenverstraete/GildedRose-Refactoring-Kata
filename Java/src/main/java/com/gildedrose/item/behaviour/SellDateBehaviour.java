package com.gildedrose.item.behaviour;

import com.gildedrose.Item;
import com.sun.istack.internal.NotNull;

public interface SellDateBehaviour {
    void updateSellDate(@NotNull final Item item);
}