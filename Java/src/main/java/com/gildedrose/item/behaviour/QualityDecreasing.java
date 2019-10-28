package com.gildedrose.item.behaviour;

public class QualityDecreasing implements QualityBehaviour {
    @Override
    public int getChangeInQuality(int sellDate) {
        return -1;
    }
}
