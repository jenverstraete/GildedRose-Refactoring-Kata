package com.gildedrose.item.behaviour;

public class QualityAfterSellDateDecreasing implements QualityAfterSellDateBehaviour {
    @Override
    public int getChangeInQualityAfterSelldate(int currentQuality) {
        return -1;
    }
}
