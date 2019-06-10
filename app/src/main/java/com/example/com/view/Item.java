package com.example.com.view;

public class Item {

    String img;
    String name;
    int Quantity;
    int sold=2;
    int priceInsid;
    int priceOutsid;
    String Date;

    public Item() {

    }

    public int getSold() {
        return sold;
    }

    public Item(String name, int quantity, int priceInsid, int priceOutsid, String date) {
        this.name = name;
        Quantity = quantity;
        this.priceInsid = priceInsid;
        this.priceOutsid = priceOutsid;
        Date = date;
    }
    public Item(String img, String name, int quantity, int priceInsid, int priceOutsid, String date) {
        this.img = img;
        this.name = name;
        Quantity = quantity;
        this.priceInsid = priceInsid;
        this.priceOutsid = priceOutsid;
        Date = date;
    }


    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public void incsold() {
        Quantity--;
        sold++;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public int getPriceInsid() {
        return priceInsid;
    }

    public int getPriceOutsid() {
        return priceOutsid;
    }

    public void setPriceInsid(int priceInsid) {
        this.priceInsid = priceInsid;
    }

    public void setPriceOutsid(int priceOutsid) {
        this.priceOutsid = priceOutsid;
    }

    public String getDate() {
        return Date;
    }
}
