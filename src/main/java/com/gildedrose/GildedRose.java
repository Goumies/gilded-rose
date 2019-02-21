package com.gildedrose;

import java.util.stream.IntStream;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            if (AGED_BRIE.equals(item.name)) {
                updateAgedBrie(item);
            } else if (BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.equals(item.name)) {
                updateBackstagePasses(item);
            } else {
                updatedefaultItem(item);
            }

        }
    }

    private void updatedefaultItem(Item item) {
        if (item.quality <= 0) {
            decreaseSellIn(item);
        }

        if (item.quality > 0) {
            decreaseQuality(item);
        }

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                decreaseQuality(item);
            }
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void updateBackstagePasses(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    increaseQuality(item);
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    increaseQuality(item);
                }
            }

            if (item.sellIn < 0) {
                resetQuality(item);
            }
        }
    }

    private void resetQuality(Item item) {
        item.quality = 0;
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private void updateAgedBrie(Item item) {
        if (item.quality < 50 || item.sellIn < 0) {
            increaseQuality(item);
        }
    }
}