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
        IntStream.range(0, items.length).forEach(index -> {
            final Item currentItem = items[index];
            if (!AGED_BRIE.equals(currentItem.name)
                    && !BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.equals(currentItem.name)) {
                if (currentItem.quality > 0) {
                    if (!SULFURAS_HAND_OF_RAGNAROS.equals(currentItem.name)) {
                        updateDefaultItem(currentItem);
                    }
                }
            } else {
                if (currentItem.quality < 50) {
                    updateAgedBrie(currentItem);
                    if (BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.equals(currentItem.name)) {
                        if (currentItem.sellIn < 11) {
                            if (currentItem.quality < 50) {
                                updateBackstagePassesToATafkal80EtcConcert(currentItem);
                            }
                        }
                    }
                }
            }
            if (!SULFURAS_HAND_OF_RAGNAROS.equals(currentItem.name)) {
                currentItem.sellIn = currentItem.sellIn - 1;
            }
            if (currentItem.sellIn < 0) {
                if (!AGED_BRIE.equals(currentItem.name)) {
                    if (!BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.equals(currentItem.name)) {
                        if (currentItem.quality > 0) {
                            if (!SULFURAS_HAND_OF_RAGNAROS.equals(currentItem.name)) {
                                updateDefaultItem(currentItem);
                            }
                        }
                    } else {
                        currentItem.quality = currentItem.quality - currentItem.quality;
                    }
                } else {
                    if (currentItem.quality < 50) {
                        currentItem.quality = currentItem.quality + 1;
                    }
                }
            }
        });
    }

    private void updateAgedBrie(Item currentItem) {
        currentItem.quality = currentItem.quality + 1;
    }

    private void updateBackstagePassesToATafkal80EtcConcert(Item currentItem) {
        currentItem.quality = currentItem.quality + 1;
    }

    private void updateDefaultItem(Item currentItem) {
        currentItem.quality = currentItem.quality - 1;
    }
}