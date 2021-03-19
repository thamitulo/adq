package com.ae.adq.maha.interview.rest;

import com.ae.adq.maha.interview.services.PriceCalculationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private PriceCalculationsService priceCalculationsService;

    @PostMapping(value = "/checkout", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> checkout(@RequestBody List<String> watchIDs) {
        return ResponseEntity.ok(priceCalculationsService.computeTotalPrice(watchIDs));
    }
}
