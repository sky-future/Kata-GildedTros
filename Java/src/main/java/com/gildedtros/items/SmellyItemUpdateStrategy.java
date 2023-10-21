package com.gildedtros.items;

import com.gildedtros.Item;
import com.gildedtros.utils.ItemUtility;

public class SmellyItemUpdateStrategy implements UpdateQualityStrategyInterface{
    @Override
    public void updateQuality(Item item) {
        ItemUtility.decreaseQuality(item);
        ItemUtility.decreaseQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) {
            ItemUtility.decreaseQuality(item);
            ItemUtility.decreaseQuality(item);
        }
    }
}
