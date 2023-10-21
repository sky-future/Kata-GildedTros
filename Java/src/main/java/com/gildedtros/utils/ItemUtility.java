package com.gildedtros.utils;

import com.gildedtros.Item;

public class ItemUtility {
    static final int MAX_QUALITY = 50;
    static final int MIN_QUALITY = 0;
    private ItemUtility() {
    }

    public static void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    public static void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }
}
