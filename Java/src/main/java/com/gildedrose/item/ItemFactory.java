package com.gildedrose.item;

import com.gildedrose.item.behaviour.*;
import com.sun.istack.internal.NotNull;

public class ItemFactory {
    private final int defaultMaxQuality = 50;
    private final int legendaryItemMaxQuality = 80;

    public ItemImpl createRegularItem(@NotNull final String name, final int sellIn, final int quality) {
        return new ItemImpl(name, sellIn, quality, defaultMaxQuality
                , new QualityDecreasing(), new SellDateDecreasing(), new QualityAfterSellDateDecreasing());
    }

    public ItemImpl createImprovingItem(@NotNull final String name, final int sellIn, final int quality) {
        return new ItemImpl(name, sellIn, quality, defaultMaxQuality
                , new QualityIncreasing(), new SellDateDecreasing(), new QualityAfterSellDateIncreasing());
    }

    public ItemImpl createLegendaryItem(@NotNull final String name, final int sellIn, final int quality) {
        return new ItemImpl(name, sellIn, quality, legendaryItemMaxQuality
                , new QualityConstant(), new SellDateConstant(), new QualityAfterSellDateConstant());
    }

    public ItemImpl createDisposableItem(@NotNull final String name, final int sellIn, final int quality) {
        return new ItemImpl(name, sellIn, quality, defaultMaxQuality
                , new QualityIncreasingExponential(), new SellDateDecreasing(), new QualityAfterSellDateZero());
    }
}
