package com.gildedtros.enums;

public enum ItemNameEnum {
    RING_OF_CLEANSING_CODE("Ring of Cleansening Code"),
    GOOD_WINE("Good Wine"),
    ELIXIR_OF_THE_SOLID("Elixir of the SOLID"),
    B_DAWG_KEYCHAIN("B-DAWG Keychain"),
    BACKSTAGE_PASSES_FOR_RE_FACTOR("Backstage passes for Re:Factor"),
    BACKSTAGE_PASSES_FOR_HAXX("Backstage passes for HAXX"),
    DUPLICATE_CODE("Duplicate Code"),
    LONG_METHODS("Long Methods"),
    UGLY_VARIABLE_NAMES("Ugly Variable Names"),
    UNRECOGNIZED_ITEM("Unrecognized Item");

    public final String value;

    ItemNameEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ItemNameEnum fromString(String text) {
        for (ItemNameEnum name : ItemNameEnum.values()) {
            if (name.value.equalsIgnoreCase(text)) {
                return name;
            }
        }
        return ItemNameEnum.UNRECOGNIZED_ITEM;
    }
}
