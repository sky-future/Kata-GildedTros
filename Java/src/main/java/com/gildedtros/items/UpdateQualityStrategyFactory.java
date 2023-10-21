package com.gildedtros.items;

import com.gildedtros.Item;
import com.gildedtros.enums.ItemNameEnum;

import static com.gildedtros.enums.ItemNameEnum.GOOD_WINE;

public class UpdateQualityStrategyFactory {
    public static UpdateQualityStrategyInterface getStrategy(Item item) {
        ItemNameEnum itemNameEnum = ItemNameEnum.fromString(item.name);
        switch (itemNameEnum) {
            case GOOD_WINE:
                return new GoodWineUpdateStrategy();
            case B_DAWG_KEYCHAIN:
                return new LegendaryItemUpdateStrategy();
            case BACKSTAGE_PASSES_FOR_RE_FACTOR:
            case BACKSTAGE_PASSES_FOR_HAXX:
                return new BackstagePassesUpdateStrategy();
            default:
                return new StandardItemUpdateStrategy();
        }
    }
}
