package com.gildedtros.items;

import com.gildedtros.Item;

public class SmellyItemUpdateStrategy implements UpdateQualityStrategyInterface{
    @Override
    public void updateQuality(Item item) {
        decreaseQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        // The quality degrades twice as fast, we decrease it by 2 units
        if (item.quality > 0) {
            item.quality = Math.max(item.quality - 2, 0);
        }

    }
}
