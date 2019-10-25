package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        NewItem[] items = new NewItem[]{
                new NewItem("+5 Dexterity Vest", 10, 20, true), //
                new NewItem("Aged Brie", 2, 0, true), //
                new NewItem("Elixir of the Mongoose", 5, 7, true), //
                new NewItem("Sulfuras, Hand of Ragnaros", 0, 80, false), //
                new NewItem("Sulfuras, Hand of Ragnaros", -1, 80, false),
                new ItemWithNoValuePastSelldate("Backstage passes to a TAFKAL80ETC concert", 15, 20, true),
                new ItemWithNoValuePastSelldate("Backstage passes to a TAFKAL80ETC concert", 10, 49, true),
                new ItemWithNoValuePastSelldate("Backstage passes to a TAFKAL80ETC concert", 5, 49, true),
                // this conjured item does not work properly yet
                new NewItem("Conjured Mana Cake", 3, 6, true)};

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
