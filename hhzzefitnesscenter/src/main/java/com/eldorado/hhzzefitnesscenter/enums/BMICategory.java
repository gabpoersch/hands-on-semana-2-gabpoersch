package com.eldorado.hhzzefitnesscenter.enums;

public enum BMICategory {
    UNDERWEIGHT("0 - Underweight"),
    NORMAL("I - Normal"),
    OVERWEIGHT("II - Overweight"),
    OBESE("III - Obese"),
    MORBID_OBESE("IV - Morbid Obese");

    private final String category;

    BMICategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}