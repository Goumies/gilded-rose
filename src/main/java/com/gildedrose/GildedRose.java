package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            if (AGED_BRIE.equals(item.name)) {
                if (item.quality < 50 || item.sellIn < 0) {
                    item.quality = item.quality + 1;
                }
            } else if (BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.equals(item.name)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 0) {
                        item.quality = item.quality - item.quality;
                    }
                }
            } else {
                if (item.quality <= 0) {
                    item.sellIn = item.sellIn - 1;
                }

                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }


                if (item.sellIn < 0) {
                    if (item.quality > 0) {
                        if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                            continue;
                        }
                        item.quality = item.quality - 1;
                    }
                }
            }

        }
    }
}