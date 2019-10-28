package com.gildedrose.item.behaviour;

public class QualityIncreasingExponential implements QualityBehaviour {
    /*@Override
    public void getChangeInQuality(@NotNull final ItemImpl item) {
        item.incrementQuality();
        if (item.sellIn < 11) {
            item.incrementQuality();
        }
        if (item.sellIn < 6) {
            item.incrementQuality();
        }
    }*/

    @Override
    public int getChangeInQuality(int sellDate) {
        return sellDate < 6 ? 3 : sellDate < 11 ? 2 : 1;
    }
}
