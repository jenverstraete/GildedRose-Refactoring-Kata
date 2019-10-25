package com.gildedrose.item.behaviour;

import com.gildedrose.Item;

public class SellDateDecreasing implements SellDateBehaviour {
    @Override
    public void updateSellDate(final Item item) {
        item.sellIn = item.sellIn - 1;
    }
}
