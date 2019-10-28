package com.gildedrose.item.behaviour;

public class QualityAfterSellDateZero implements QualityAfterSellDateBehaviour {
    @Override
    public int getChangeInQualityAfterSelldate(int currentQuality) {
        return -currentQuality;
    }
}
