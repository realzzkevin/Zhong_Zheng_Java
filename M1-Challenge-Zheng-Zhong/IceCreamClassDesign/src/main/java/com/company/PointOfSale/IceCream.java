package com.company.PointOfSale;

public class IceCream {
    private String brand;
    private String expirationDate;
    private String flavor;
    private String sku;
    private double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public IceCream() {};
    public IceCream(String brand, String flavor, String sku, double price, String date) {
        this.brand = brand;
        this.flavor = flavor;
        this.sku = sku;
        this.price = price;
        this.expirationDate = date;
    }

    public void createShelfLabel (){
        System.out.println("==============================================");
        System.out.println("Brand: "+this.brand+" Flavor: "+ this.flavor+" Unit Price: $"+this.price + "");
        System.out.println("SKU: "+ this.sku +" Expiration date:  "+ this.expirationDate);
        System.out.println("===============================================");
    }

    public double totalSaleAmount( int quantity) {
        return price * quantity;
    }

    public void displayExpirationDate() {
        System.out.println("Please Enjoy this Ice Cream before: " + this.expirationDate);
    }
}
