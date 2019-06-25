package com.example.priceshoprecyclermvvm.model;

public class PriceModel {

    private int fixed_price = 1500;
    private int unit_price;
    private int total_price;

//    public static PriceModel priceModel;
//
//
//    public PriceModel() {
//        priceModel = this;
//    }

    public int getFixed_price() {
        return fixed_price;
    }

    public void setFixed_price(int fixed_price) {
        this.fixed_price = fixed_price;

    }

    public int getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;

    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;

    }


//    public static PriceModel getPriceModel() {
//        return priceModel;
//    }
}
