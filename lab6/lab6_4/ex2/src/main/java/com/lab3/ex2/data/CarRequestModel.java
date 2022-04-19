package com.lab3.ex2.data;


public class CarRequestModel {
    
    private Long carId;

    private String maker;
    private String model;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
    
    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    @Override
    public String toString() {
        return "{" +
            " carId='" + getCarId() + "'" +
            ", maker='" + getMaker() + "'" +
            ", model='" + getModel() + "'" +
            "}";
    }
}
