package com.gildedrose;

import com.gildedrose.item.ItemFactory;
import com.gildedrose.item.ItemImpl;

public class TexttestFixture {
    private final static ItemFactory itemFactory = new ItemFactory();

    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        ItemImpl[] items = new ItemImpl[]{
                itemFactory.createRegularItem("+5 Dexterity Vest", 10, 20),
                itemFactory.createImprovingItem("Aged Brie", 2, 0),
                itemFactory.createRegularItem("Elixir of the Mongoose", 5, 7),
                itemFactory.createLegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80),
                itemFactory.createLegendaryItem("Sulfuras, Hand of Ragnaros", -1, 80),
                itemFactory.createDisposableItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                itemFactory.createDisposableItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                itemFactory.createDisposableItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                itemFactory.createRegularItem("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
