package com.gildedtros;

import org.junit.jupiter.api.Test;

import static com.gildedtros.enums.ItemNameEnum.GOOD_WINE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item(GOOD_WINE.getValue(), 0, 0) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals("Good Wine", app.items[0].name);
    }

}
