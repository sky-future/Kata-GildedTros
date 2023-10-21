package com.gildedtros.items;

import com.gildedtros.Item;

public class StandardItemUpdateStrategy implements UpdateQualityStrategyInterface {
    @Override
    public void updateQuality(Item item) {
        decreaseQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
