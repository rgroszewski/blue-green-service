package com.rg.bluegreen;

public class Color {

    private final String color;

    public Color(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }

    public static String getSystemColor()
    {
        String color = System.getenv("deployment");
        color = color!=null?color:"purple";
        return color;
    }
}