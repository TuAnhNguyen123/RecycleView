package com.example.recycleview;

public enum BusinessType {
    SHOP_ONLINE("Shop Online"), BISTRO("Bistro"), RESTAURANT("Restaurant");

private final String name;
    BusinessType(String text) {
        name = text;
    }

    @Override
    public String toString() {
        return name;
    }
}
