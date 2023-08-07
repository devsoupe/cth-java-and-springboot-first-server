package com.group.libraryapp.controller.user;

public class Fruit {

    private Long id;

    protected Fruit() {

    }

    private String name;
    private int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
