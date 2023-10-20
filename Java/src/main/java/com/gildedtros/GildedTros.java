package com.gildedtros;

import static com.gildedtros.enums.ItemNameEnum.*;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(GOOD_WINE.getValue())
                    && !item.name.equals(BACKSTAGE_PASSES_FOR_RE_FACTOR.getValue())
                    && !item.name.equals(BACKSTAGE_PASSES_FOR_HAXX.getValue())) {
                if (item.quality > 0) {
                    if (!item.name.equals(B_DAWG_KEYCHAIN.getValue())) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(BACKSTAGE_PASSES_FOR_RE_FACTOR.getValue()) || item.name.equals(BACKSTAGE_PASSES_FOR_HAXX.getValue())) {
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

            if (!item.name.equals(B_DAWG_KEYCHAIN.getValue())) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(GOOD_WINE.getValue())) {
                    if (!item.name.equals(BACKSTAGE_PASSES_FOR_RE_FACTOR.getValue()) && !item.name.equals(BACKSTAGE_PASSES_FOR_HAXX.getValue())) {
                        if (item.quality > 0) {
                            if (!item.name.equals(B_DAWG_KEYCHAIN.getValue())) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
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