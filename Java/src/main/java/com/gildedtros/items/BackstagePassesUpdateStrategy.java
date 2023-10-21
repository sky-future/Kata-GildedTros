package com.gildedtros.items;

import com.gildedtros.Item;

public class BackstagePassesUpdateStrategy implements UpdateQualityStrategyInterface{
    @Override
    public void updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality++;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality++;
                }
            }
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
