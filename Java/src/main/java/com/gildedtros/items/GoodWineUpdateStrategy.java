package com.gildedtros.items;

import com.gildedtros.Item;
import com.gildedtros.utils.ItemUtility;

public class GoodWineUpdateStrategy implements UpdateQualityStrategyInterface {
    @Override
    public void updateQuality(Item item) {
        ItemUtility.increaseQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) {
            ItemUtility.increaseQuality(item);
        }
    }
}
