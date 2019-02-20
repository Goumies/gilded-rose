package com.gildedrose;

import java.util.stream.IntStream;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        update();
    }

    private void update() {
        IntStream.range(0, items.length).forEach(i -> {
            if (!AGED_BRIE.equals(items[i].name)
                    && !BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.equals(items[i].name)) {
                if (items[i].quality > 0) {
                    if (!SULFURAS_HAND_OF_RAGNAROS.equals(items[i].name)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.equals(items[i].name)) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }
            if (!SULFURAS_HAND_OF_RAGNAROS.equals(items[i].name)) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            if (items[i].sellIn < 0) {
                if (!AGED_BRIE.equals(items[i].name)) {
                    if (!BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.equals(items[i].name)) {
                        if (items[i].quality > 0) {
                            if (!SULFURAS_HAND_OF_RAGNAROS.equals(items[i].name)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        });
    }
}