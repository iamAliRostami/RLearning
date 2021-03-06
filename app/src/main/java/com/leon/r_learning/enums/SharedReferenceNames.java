package com.leon.r_learning.enums;

public enum SharedReferenceNames {
    ACCOUNT("com.app.leon.reading_counter.account_info");

    private final String value;

    SharedReferenceNames(final String newValue) {
        value = newValue;
    }

    public String getValue() {
        return value;
    }
}
