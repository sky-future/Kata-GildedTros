package com.gildedtros.items;

import com.gildedtros.Item;
import com.gildedtros.enums.ItemNameEnum;

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
            case DUPLICATE_CODE:
            case LONG_METHODS:
            case UGLY_VARIABLE_NAMES:
                return new SmellyItemUpdateStrategy();
            default:
                return new StandardItemUpdateStrategy();
        }
    }
}
