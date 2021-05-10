package com.leon.r_learning.enums;

public enum CompanyNames {
    CRYPTO_CURRENCY(1);

    private final int value;

    CompanyNames(final int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }

}
