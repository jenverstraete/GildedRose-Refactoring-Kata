package com.gildedrose.item.behaviour;

public class QualityIncreasingExponential implements QualityBehaviour {
    @Override
    public int getChangeInQuality(int sellDate) {
        return sellDate < 6 ? 3 : sellDate < 11 ? 2 : 1;
    }
}
