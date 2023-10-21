package com.gildedtros;

import com.gildedtros.items.UpdateQualityStrategyFactory;
import com.gildedtros.items.UpdateQualityStrategyInterface;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateGildedTrosInventory() {
        for (Item item : items) {
            UpdateQualityStrategyInterface updateQualityStrategy = UpdateQualityStrategyFactory.getStrategy(item);
            updateQualityStrategy.updateQuality(item);
        }
    }

//    private static void updateDailyItemFromInventory(Item item) {
//        updateItemQuality(item);
//        updateItemSellIn(item);
//    }
//
//    private static void updateItemQuality(Item item) {
//        if (item.name.equals(GOOD_WINE.getValue())) {
//            increaseQuality(item);
//        } else if (item.name.equals(BACKSTAGE_PASSES_FOR_RE_FACTOR.getValue()) || item.name.equals(BACKSTAGE_PASSES_FOR_HAXX.getValue())) {
//            increaseQuality(item);
//            if (item.sellIn < 11) {
//                increaseQuality(item);
//            }
//
//            if (item.sellIn < 6) {
//                increaseQuality(item);
//            }
//        } else if (item.name.equals(B_DAWG_KEYCHAIN.getValue())) {
//            return;
//        } else decreaseQuality(item);
//    }
//
//    private static void updateItemSellIn(Item item) {
//        updateExpiration(item);
//
//        if (isExpired(item)) {
//            handleExpiredItems(item);
//        }
//    }
//
//    private static void updateExpiration(Item item) {
//        if (item.name.equals(B_DAWG_KEYCHAIN.getValue())) {
//            return;
//        }
//        item.sellIn--;
//    }
//
//    private static boolean isExpired(Item item) {
//        return item.sellIn < 0;
//    }
//
//    private static void handleExpiredItems(Item item) {
//        if (item.name.equals(GOOD_WINE.getValue())) {
//            increaseQuality(item);
//        } else if (item.name.equals(BACKSTAGE_PASSES_FOR_RE_FACTOR.getValue()) || item.name.equals(BACKSTAGE_PASSES_FOR_HAXX.getValue())) {
//            item.quality = 0;
//        } else if (item.name.equals(B_DAWG_KEYCHAIN.getValue())) {
//            return;
//        } else {
//            decreaseQuality(item);
//        }
//    }
//
//    private static void decreaseQuality(Item item) {
//        if (item.quality > 0) {
//            item.quality--;
//        }
//    }
//
//    private static void increaseQuality(Item item) {
//        if (item.quality < 50) {
//            item.quality++;
//        }
//    }
}