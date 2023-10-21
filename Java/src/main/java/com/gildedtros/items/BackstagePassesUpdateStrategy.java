package com.gildedtros.items;

import com.gildedtros.Item;
import com.gildedtros.utils.ItemUtility;

public class BackstagePassesUpdateStrategy implements UpdateQualityStrategyInterface {
    @Override
    public void updateQuality(Item item) {
        ItemUtility.increaseQuality(item);

        if (item.sellIn < 11) {
            ItemUtility.increaseQuality(item);
        }

        if (item.sellIn < 6) {
            ItemUtility.increaseQuality(item);
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
