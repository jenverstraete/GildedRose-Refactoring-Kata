package com.gildedrose.item.behaviour;

public class QualityIncreasing implements QualityBehaviour {
    @Override
    public int getChangeInQuality(int sellDate) {
        return 1;
    }
}
