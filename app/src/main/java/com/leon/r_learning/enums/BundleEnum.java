package com.leon.r_learning.enums;

public enum BundleEnum {
    LESSON_ID("lesson_id"),
    COURSE_ID("course_id"),
    SECTION_NUMBER("section_number"),
    TYPE("type");

    private final String value;

    BundleEnum(final String newValue) {
        value = newValue;
    }

    public String getValue() {
        return value;
    }
}
