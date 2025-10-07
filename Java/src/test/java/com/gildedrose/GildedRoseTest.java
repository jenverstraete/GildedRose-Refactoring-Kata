package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GildedRoseTest {
    @Test
    void testQualityDegradationOfRandomItem() {
        GildedRose app = new GildedRose(new Item[] { new Item("random", 1, 50) });
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void testQualityDegradationPastDueDateOfRandomItem() {
        GildedRose app = new GildedRose(new Item[] { new Item("random", 0, 50) });
        app.updateQuality();
        assertEquals(48, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void testQualityIsNeverNegative() {
        GildedRose app = new GildedRose(new Item[] { new Item("random", 0, 0) });
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void testProvidingNegativeQualityIgnoresQualityChanges() {
        GildedRose app = new GildedRose(new Item[] { new Item("random", 0, -2) });
        app.updateQuality();
        assertEquals(-2, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void testBrieQualityIncrease() {
        GildedRose app = new GildedRose(new Item[] { new Item("Aged Brie", 100, 0) });
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
        assertEquals(99, app.items[0].sellIn);
    }

    @Test
    void testBrieQualityIncreaseDoublesPastDueDate() {
        GildedRose app = new GildedRose(new Item[] { new Item("Aged Brie", -1, 13) });
        app.updateQuality();
        assertEquals(15, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void testBrieQualityIncreaseStopsAt50PastDueDate() {
        GildedRose app = new GildedRose(new Item[] { new Item("Aged Brie", -1, 49) });
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void testBrieQualityIncreaseStopsAt50() {
        GildedRose app = new GildedRose(new Item[] { new Item("Aged Brie", 2, 49) });
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void testSulfurasQualityAndSellDateRemainUnchanged() {
        GildedRose app = new GildedRose(new Item[] { new Item("Sulfuras, Hand of Ragnaros", 100, 80) });
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(100, app.items[0].sellIn);
    }

    @Test
    void testSulfurasQualityPastDueDate() {
        GildedRose app = new GildedRose(new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) });
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void testBackstagePassesQualityIncreaseBasic() {
        GildedRose app = new GildedRose(new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) });
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    void testBackstagePassesQualityIncreaseLessThan10Days() {
        GildedRose app = new GildedRose(new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10) });
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }

    @Test
    void testBackstagePassesQualityIncreasesNotPast50WhenLessThan10Days() {
        GildedRose app = new GildedRose(new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 50) });
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }

    @Test
    void testBackstagePassesQualityIncreaseLessThan5Days() {
        GildedRose app = new GildedRose(new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10) });
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void testBackstagePassesQualityIncreasesNotPast50WhenLessThan5Days() {
        GildedRose app = new GildedRose(new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50) });
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void testBackstagePassesQualityIs0PastDueDate() {
        GildedRose app = new GildedRose(new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49) });
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void testQualityDegradationOfConjuredItem() {
        GildedRose app = new GildedRose(new Item[] { new Item("Conjured", 1, 50) });
        app.updateQuality();
        assertEquals(48, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void testQualityDegradationPastDueDateOfConjuredItem() {
        GildedRose app = new GildedRose(new Item[] { new Item("Conjured", 0, 50) });
        app.updateQuality();
        assertEquals(46, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void testConjuredItemQualityIsNeverNegative() {
        GildedRose app = new GildedRose(new Item[] { new Item("Conjured", 0, 1) });
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
}
