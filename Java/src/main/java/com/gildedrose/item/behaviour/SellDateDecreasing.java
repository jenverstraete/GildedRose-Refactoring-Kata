package com.gildedrose.item.behaviour;

public class SellDateDecreasing implements SellDateBehaviour {
    @Override
    public int getChangeInSellDate() {
        return -1;
    }
}
