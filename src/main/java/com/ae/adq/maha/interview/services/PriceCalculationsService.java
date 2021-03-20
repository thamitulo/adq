package com.ae.adq.maha.interview.services;

import com.ae.adq.maha.interview.entities.Inventory;
import com.ae.adq.maha.interview.models.response.InventoryPayload;
import com.ae.adq.maha.interview.repositories.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Transactional
@Service
public class PriceCalculationsService implements CalculationsInterface {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public double computeDiscount(Long qty, Inventory inventory) {
        BigDecimal discountedPrice, totalPrice;

        if(qty.intValue() >=  inventory.getDiscountUnits()) {
            totalPrice =  BigDecimal.valueOf(qty  * inventory.getUnitPrice() )  ;
            discountedPrice = totalPrice.multiply( BigDecimal.valueOf(inventory.getDiscountPercentage() / 100) );
            return totalPrice.subtract(discountedPrice).setScale(0, RoundingMode.HALF_UP).doubleValue()  ;

        }
        return  qty * inventory.getUnitPrice();
    }

    @Override
    public InventoryPayload computeTotalPrice(List<String> codes) {
        log.info("Codes {} ", codes);
        Map<String, Long> aggregator =
                codes.stream().collect(Collectors.groupingBy(code -> code, Collectors.counting()));
        InventoryPayload payload = new InventoryPayload();

        log.info("Aggregator {} ", aggregator);
        aggregator.forEach((key, value) -> inventoryRepository.findByCode(key)
                .ifPresent(inventory -> payload.setTotalPrice(computeDiscount(value, inventory))));

        return payload;
    }

}