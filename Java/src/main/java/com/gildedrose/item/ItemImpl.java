package com.gildedrose.item;

import com.gildedrose.item.behaviour.QualityAfterSellDateBehaviour;
import com.gildedrose.item.behaviour.QualityBehaviour;
import com.gildedrose.item.behaviour.SellDateBehaviour;

public class ItemImpl extends com.gildedrose.Item implements Item {
    private final QualityBehaviour qualityBehaviour;
    private final SellDateBehaviour sellDateBehaviour;
    private final QualityAfterSellDateBehaviour qualityAfterSellDateBehaviour;
    private final int maxQuality;

    ItemImpl(final String name, final int sellIn, final int quality, final int maxQuality,
             final QualityBehaviour qualityBehaviour, final SellDateBehaviour sellDateBehaviour,
             final QualityAfterSellDateBehaviour qualityAfterSellDateBehaviour) {
        super(name, sellIn, quality);

        this.qualityBehaviour = qualityBehaviour;
        this.sellDateBehaviour = sellDateBehaviour;
        this.qualityAfterSellDateBehaviour = qualityAfterSellDateBehaviour;
        this.maxQuality = maxQuality;
    }

    @Override
    public void updateQuality() {
        changeQualityWith(qualityBehaviour.getChangeInQuality(sellIn));
    }

    @Override
    public void updateSellDate() {
        sellIn += sellDateBehaviour.getChangeInSellDate();
    }

    @Override
    public void updateQualityAfterDeadline() {
        if (sellIn < 0) {
            changeQualityWith(qualityAfterSellDateBehaviour.getChangeInQualityAfterSelldate(quality));
        }
    }

    private void changeQualityWith(int qualityChange) {
        quality += qualityChange;
        applyQualityBounds(quality > maxQuality, maxQuality);
        applyQualityBounds(quality < 0, 0);
    }

    private void applyQualityBounds(final boolean updateQuality, final int limitedQuality) {
        if (updateQuality) {
            quality = limitedQuality;
        }
    }
}
