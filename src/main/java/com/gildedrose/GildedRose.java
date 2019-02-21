package com.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            if ("Aged Brie".equals(item.name)) {

            } else {
                if (!"Aged Brie".equals(item.name)
                        && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;

                        if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
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
                        }
                    }
                }

                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.sellIn = item.sellIn - 1;
                }

                if (item.sellIn < 0) {
                    if (!"Aged Brie".equals(item.name)) {
                        if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                            if (item.quality > 0) {
                                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                    item.quality = item.quality - 1;
                                }
                            }
                        } else {
                            item.quality = item.quality - item.quality;
                        }
                    } else {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }

        }
    }
}