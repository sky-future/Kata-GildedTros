package com.gildedtros.items;

import com.gildedtros.Item;

public class LegendaryItemUpdateStrategy implements UpdateQualityStrategyInterface{
    @Override
    public void updateQuality(Item item) {
        // Legendary items never change
    }
}
