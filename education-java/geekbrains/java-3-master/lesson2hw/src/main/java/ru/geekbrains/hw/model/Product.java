package ru.geekbrains.hw.model;

public class Product {
    private int id;
    private int prodid;
    private String title;
    private int cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdid() {
        return prodid;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product "
                + "id: " + getId()
                + " prodid: " + getProdid()
                + " title: " + getTitle()
                + " cost: " + getCost();
    }
}
