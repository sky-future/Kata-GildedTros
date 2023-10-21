package com.gildedtros;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.gildedtros.enums.ItemNameEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item(GOOD_WINE.getValue(), 0, 0) };
        GildedTros app = new GildedTros(items);
        app.updateGildedTrosInventory();

        assertEquals("Good Wine", app.items[0].name);
    }

    @Test
    @DisplayName("At the end of each day our system lowers both values for every item")
    void at_the_end_of_each_day_our_system_lowers_both_values_for_every_item() {
        Item item = new Item("random Item", 10, 10);
        GildedTros subject = new GildedTros(new Item[] { item });
        subject.updateGildedTrosInventory();

        assertEquals(9, item.sellIn);
        assertEquals(9, item.quality);
    }

    @Test
    @DisplayName("Multiple items are updated each day")
    void multiple_items_are_updated() {
        Item item1 = new Item("random Item", 10, 10);
        Item item2 = new Item("random Item", 10, 10);
        GildedTros subject = new GildedTros(new Item[] { item1, item2 });
        subject.updateGildedTrosInventory();

        assertEquals(9, item1.sellIn);
        assertEquals(9, item1.quality);
        assertEquals(9, item2.sellIn);
        assertEquals(9, item2.quality);
    }

    @Test
    @DisplayName("Once the sell by date has passed, Quality degrades twice as fast")
    void sellByDate_passed_quality_degrades_twice_as_fast() {
        Item item = new Item("random Item", 0, 10);
        GildedTros subject = new GildedTros(new Item[] { item });
        subject.updateGildedTrosInventory();

        assertEquals(8, item.quality);
    }

    @Test
    @DisplayName("The Quality of an item is never negative")
    void item_quality_is_never_negative() {
        Item item = new Item("Random item", 4, 0);
        GildedTros subject = new GildedTros(new Item[] { item });
        subject.updateGildedTrosInventory();

        assertEquals(0, item.quality);
    }

    @Test
    @DisplayName("The quality of good wine is never above 50")
    void good_wine_quality_is_never_more_than_50() {
        Item item = new Item(GOOD_WINE.getValue(), 5, 50);
        GildedTros subject = new GildedTros(new Item[] { item });
        subject.updateGildedTrosInventory();

        assertEquals(50, item.quality);
    }

    @Test
    void quality_of_an_item_is_never_greater_than_50() {
        Item item = new Item(GOOD_WINE.getValue(), 0, 50);
        GildedTros subject = new GildedTros(new Item[] { item });
        subject.updateGildedTrosInventory();

        assertEquals(50,item.quality);
    }

    @ParameterizedTest
    @MethodSource("provideBackstagePassScenarios")
    @DisplayName("Backstage passes quality adjustment")
    void backstagePassesQualityAdjustment(String itemName, int sellIn, int initialQuality, int expectedQuality) {
        // Create an item with the provided parameters.
        Item item = new Item(itemName, sellIn, initialQuality);
        GildedTros subject = new GildedTros(new Item[] { item });
        subject.updateGildedTrosInventory();

        assertEquals(expectedQuality, item.quality);
    }

    // This method provides the parameters for the test cases.
    private static Stream<Arguments> provideBackstagePassScenarios() {
        return Stream.of(
                // Parameters: itemName, sellIn, initialQuality, expectedQuality
                Arguments.of(BACKSTAGE_PASSES_FOR_RE_FACTOR.getValue(), 10, 20, 22), // Quality increases by 2 with 10 days or less
                Arguments.of(BACKSTAGE_PASSES_FOR_HAXX.getValue(), 5, 20, 23), // Quality increases by 3 with 5 days or less
                Arguments.of(BACKSTAGE_PASSES_FOR_RE_FACTOR.getValue(), 0, 20, 0)  // Quality drops to 0 after the event
        );
    }

    @Test
    @DisplayName("Backstage passes quality is never more than 50")
    void backstage_passes_quality_is_never_more_than_50() {
        Item item = new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR.getValue(), 10, 50);
        GildedTros subject = new GildedTros(new Item[] { item });
        subject.updateGildedTrosInventory();

        assertEquals(50, item.quality);
    }

    @Test
    @DisplayName("Backstage passes quality is never more than 50 even when there are 5 days or less")
    void backstage_passes_quality_is_never_more_than_50_even_when_there_are_5_days_or_less() {
        Item item = new Item(BACKSTAGE_PASSES_FOR_HAXX.getValue(), 5, 49);
        GildedTros subject = new GildedTros(new Item[] { item });
        subject.updateGildedTrosInventory();

        assertEquals(50, item.quality);
    }

    @Test
    @DisplayName("Legendary items never decrease in quality")
    void legendary_items_never_decrease_in_quality() {
        Item item = new Item(B_DAWG_KEYCHAIN.getValue(), -1, 80);
        GildedTros subject = new GildedTros(new Item[] { item });
        subject.updateGildedTrosInventory();

        assertEquals(80, item.quality);
    }

    @Test
    @DisplayName("Legendary items never decrease in sellIn")
    void legendary_items_never_have_to_be_sold() {
        Item item = new Item(B_DAWG_KEYCHAIN.getValue(), -1, 80);
        GildedTros subject = new GildedTros(new Item[] { item });
        subject.updateGildedTrosInventory();

        assertEquals(-1, item.sellIn);
    }

    @Test
    @DisplayName("Legendary items never decrease in quality or sellIn")
    void legendary_items_never_decrease_in_quality_or_sellIn() {
        Item item = new Item(B_DAWG_KEYCHAIN.getValue(), -1, 80);
        GildedTros subject = new GildedTros(new Item[] { item });
        subject.updateGildedTrosInventory();

        assertEquals(80, item.quality);
        assertEquals(-1, item.sellIn);
    }
}
