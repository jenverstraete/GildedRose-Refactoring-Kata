package com.gildedrose.item.behaviour;

public class QualityAfterSellDateIncreasing implements QualityAfterSellDateBehaviour {
    @Override
    public int getChangeInQualityAfterSelldate(int currentQuality) {
        return 1;
    }
}
