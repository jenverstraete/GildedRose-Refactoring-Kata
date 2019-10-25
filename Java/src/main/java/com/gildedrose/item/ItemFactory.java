package com.gildedrose.item;

import com.gildedrose.item.behaviour.*;

public class ItemFactory {
    public RegularItem createRegularItem(String name, int sellIn, int quality) {
        return new RegularItem(name, sellIn, quality, new QualityDecreasing(), new SellDateDecreasing(), new QualityAfterSellDateDecreasing());
    }

    public RegularItem createImprovingItem(String name, int sellIn, int quality) {
        return new RegularItem(name, sellIn, quality, new QualityIncreasing(), new SellDateDecreasing(), new QualityAfterSellDateIncreasing());
    }

    public RegularItem createLegendaryItem(final String name, final int sellIn, final int quality) {
        return new RegularItem(name, sellIn, quality, new QualityConstant(), new SellDateConstant(), new QualityAfterSellDateConstant());
    }

    public RegularItem createDisposableItem(final String name, final int sellIn, final int quality) {
        return new RegularItem(name, sellIn, quality, new QualityIncreasingExp(), new SellDateDecreasing(), new QualityAfterSellDateZero());
    }
}
