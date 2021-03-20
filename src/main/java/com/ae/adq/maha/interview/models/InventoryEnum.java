package com.ae.adq.maha.interview.models;

import java.util.*;

public enum InventoryEnum {

    ROLEX("Rolex", "001", 100d, 3, 33.3d),
    MICHAEL_KORS("Michael Kors", "002", 80d, 2, 25d),
    SWATCH("Swatch", "003", 50d, 0, 0),
    CASIO("Casio", "004", 30d, 0,0);

    private static final Map<String, InventoryEnum> BY_NAME = new HashMap<>();
    private static final Map<String, InventoryEnum> BY_CODE = new HashMap<>();

    static {
        for (InventoryEnum e : values()) {
            BY_NAME.put(e.name, e);
            BY_CODE.put(e.code, e);
        }
    }

    public final String name;
    public final String code;
    public final double unitPrice;
    public final int discountUnits;
    public final double discountPercentage;

    InventoryEnum(String name, String code, double unitPrice, int discountUnits, double discountPercentage) {
        this.name = name;
        this.code = code;
        this.unitPrice = unitPrice;
        this.discountUnits = discountUnits;
        this.discountPercentage = discountPercentage;
    }

    public static List<String> getAllCodes() {
        return new ArrayList(BY_CODE.keySet());
    }
}