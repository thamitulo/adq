package com.ae.adq.maha.interview.models.response;

import lombok.Data;

@Data
public class InventoryPayload {

    private double price;

    public void setTotalPrice(double price) {
        this.price += price;
    }
}
