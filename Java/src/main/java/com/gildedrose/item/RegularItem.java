package com.gildedrose.item;

import com.gildedrose.item.behaviour.QualityAfterSellDateBehaviour;
import com.gildedrose.item.behaviour.QualityBehaviour;
import com.gildedrose.item.behaviour.SellDateBehaviour;

public class RegularItem extends com.gildedrose.Item implements Item {
    private final QualityBehaviour qualityBehaviour;
    private final SellDateBehaviour sellDateBehaviour;
    private final QualityAfterSellDateBehaviour qualityAfterSellDateBehaviour;

    RegularItem(final String name, final int sellIn, final int quality, final QualityBehaviour qualityBehaviour,
                final SellDateBehaviour sellDateBehaviour, final QualityAfterSellDateBehaviour qualityAfterSellDateBehaviour) {
        super(name, sellIn, quality);

        this.qualityBehaviour = qualityBehaviour;
        this.sellDateBehaviour = sellDateBehaviour;
        this.qualityAfterSellDateBehaviour = qualityAfterSellDateBehaviour;
    }

    @Override
    public void updateQuality() {
        qualityBehaviour.updateQuality(this);
    }

    @Override
    public void updateSellDate() {
        sellDateBehaviour.updateSellDate(this);
    }

    @Override
    public void updateQualityAfterDeadline() {
        if (sellIn < 0) {
            qualityAfterSellDateBehaviour.updateQualityAfterSelldate(this);
        }
    }
}
