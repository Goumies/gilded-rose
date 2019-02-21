package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void given_aged_brie_item_should_return_its_name() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
    }

    @Test
    public void given_default_item_with_quality_greater_than_1_should_return_quality_decreased_by_1() {
        Item[] items = new Item[]{new Item("Other", 0, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1 - 1, app.items[0].quality);
    }

    @Test
    public void given_sulfuras_hand_of_ragnaros_item_with_quality_lower_than_50_should_return_unchanged_quality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50 + 0, app.items[0].quality);
    }

    @Test
    public void given_aged_brie_item_with_quality_lower_than_50_should_return_quality_increased_by_1() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49 + 1, app.items[0].quality);
    }

    @Test
    public void given_backstage_passes_to_a_tafkal80etc_concert_with_sellIn_lower_than_11_and_quality_lower_than_50_should_return_unchanged_quality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49 + 1, app.items[0].quality);
    }

    @Test
    public void given_backstage_passes_to_a_tafkal80etc_concert_with_sellIn_lower_than_6_and_quality_lower_than_50_should_return_unchanged_quality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49 + 1, app.items[0].quality);
    }

}
