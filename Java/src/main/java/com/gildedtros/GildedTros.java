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
}