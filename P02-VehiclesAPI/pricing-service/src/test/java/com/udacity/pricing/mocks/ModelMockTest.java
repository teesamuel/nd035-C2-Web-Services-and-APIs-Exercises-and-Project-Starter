package com.udacity.pricing.mocks;

import com.udacity.pricing.domain.price.Price;

import java.math.BigDecimal;

import static java.lang.Integer.valueOf;

public class ModelMockTest {
    public  static Price getPrice(){
        int i = 1;
        Price price = new Price();
        price.setPrice(BigDecimal.valueOf(29388.45));
        price.setVehicleId(1L);
        price.setId(1L);
        price.setCurrency("USD");
        return  price;
    }
}
