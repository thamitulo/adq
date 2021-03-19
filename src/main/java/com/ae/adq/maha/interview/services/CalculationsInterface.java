package com.ae.adq.maha.interview.services;

import com.ae.adq.maha.interview.entities.Inventory;
import com.ae.adq.maha.interview.models.response.InventoryPayload;

import java.util.List;

public interface CalculationsInterface {

    double computeDiscount(Long qty, Inventory inventory);
    InventoryPayload computeTotalPrice(List<String> codes);
}
