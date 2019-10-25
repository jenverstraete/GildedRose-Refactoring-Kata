package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.item.ItemFactory;
import com.gildedrose.item.ItemImpl;
import org.junit.Test;

public class GildedRoseTest {
    private final static ItemFactory itemFactory = new ItemFactory();

    @Test
    public void foo() {
        ItemImpl[] items = new ItemImpl[]{itemFactory.createRegularItem("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

}
