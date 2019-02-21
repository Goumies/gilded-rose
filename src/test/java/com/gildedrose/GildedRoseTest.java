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
        final int initialQuality = 0;
        Item[] items = new Item[]{new Item("Aged Brie", 0, initialQuality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(initialQuality + 1, app.items[0].quality);
    }

    @Test
    public void given_aged_brie_item_with_0_for_quality_and_negative_sellIn_should_return_1() {
        final int initialQuality = 0;
        Item[] items = new Item[]{new Item("Aged Brie", -1, initialQuality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(initialQuality + 1, app.items[0].quality);
    }

    @Test
    public void given_backstage_passes_to_a_tafkal80etc_concert_item_with_0_for_quality_and_negative_sellIn_should_return_1() {
        final int initalQuality = 0;
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, initalQuality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        final int additionalQualityForInitialQualityUnderFifty = 1;
        final int additionalQualityForInitialSellInUnderEleven = 1;
        final int additionalQualityForInitialSellInUnderSix = 1;
        assertEquals(initalQuality + additionalQualityForInitialQualityUnderFifty + additionalQualityForInitialSellInUnderEleven + additionalQualityForInitialSellInUnderSix, app.items[0].quality);
    }

}
