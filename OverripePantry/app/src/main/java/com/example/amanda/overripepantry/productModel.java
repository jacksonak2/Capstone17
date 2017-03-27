package com.example.amanda.overripepantry;

/**
 * Created by ffantl on 2/27/17.
 *
 * Basic data form for an item in an inventory.
 */


public class productModel {
    private String itemName;
    private String brandName;
    private String qtyType;
    private String upc;
    // code: Error code
    private String code;
    private double qty;
    private java.util.Date expDate;
    private java.util.Date entryDate;

    public productModel(String in, String bn, String qtyType, String upc, double qty){
        this.itemName = in;
        this.brandName = bn;
        this.qtyType = qtyType;
        this.upc = upc;
        this.qty = qty;
    }

    public productModel(){
        this.itemName = null;
        this.brandName = null;
        this.qtyType = null;
        this.upc = null;
        this.qty = 0;
    }

    public String getItemname() {
        return itemName;
    }

    public void setItemname(String itemName) {
        this.itemName = itemName;
    }

    public String getBrandname() {
        return brandName;
    }

    public void setBrandname(String brandName) {
        this.brandName = brandName;
    }

    public String getQtytype() {
        return qtyType;
    }

    public void setQtytype(String qtyType) {
        this.qtyType = qtyType;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public java.util.Date getExpDate() {
        return expDate;
    }

    public void setExpDate(java.util.Date expDate) {
        this.expDate = expDate;
    }

    public java.util.Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(java.util.Date entryDate) {
        this.entryDate = entryDate;
    }

    public boolean error() {
        if (code.equals("OK")) {
            return false;
        } else if (code.equals("INVALID_UPC")) {
            return true;
        }
        return false;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        String buff;

        buff = "Brand name: " + getBrandname() + "\n"
                + "Item name: "  + getItemname()  + "\n"
                + "UPC: "        + getCode()      + "\n"
                + "Qty: "        + getQty() + " " + getQtytype() + "\n";

        return buff;
    }
}

