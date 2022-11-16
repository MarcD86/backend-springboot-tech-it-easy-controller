package com.example.backendspringboottechiteasycontroller.service;


public class Television {

    private String brandName;

    public Television(){};

    public Television(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}

