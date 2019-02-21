package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void given_foo_item_should_return_foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void given_aged_brie_item_with_0_for_quality_should_return_1() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0 + 1, app.items[0].quality);
    }

}
