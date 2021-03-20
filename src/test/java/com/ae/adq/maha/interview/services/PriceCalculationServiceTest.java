package com.ae.adq.maha.interview.services;

import com.ae.adq.maha.interview.entities.Inventory;
import com.ae.adq.maha.interview.models.InventoryEnum;
import com.ae.adq.maha.interview.repositories.InventoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class PriceCalculationServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private PriceCalculationsService priceCalculationsService;

    @Before
    public void init() {

        Inventory rolex = buildRolex().get();
        Inventory michaelKors = buildMichaelKors().get();
        Inventory swatch = buildSwatch().get();
        Inventory casio = buildCasio().get();

        Mockito.when(inventoryRepository.findByCode(InventoryEnum.ROLEX.code)).thenReturn(Optional.of(rolex));
        Mockito.when(inventoryRepository.findByCode(InventoryEnum.MICHAEL_KORS.code)).thenReturn(Optional.of(michaelKors));
        Mockito.when(inventoryRepository.findByCode(InventoryEnum.SWATCH.code)).thenReturn(Optional.of(swatch));
        Mockito.when(inventoryRepository.findByCode(InventoryEnum.CASIO.code)).thenReturn(Optional.of(casio));
    }

    @Test
    public void shouldTestComputeDiscount() {
        List<String> purchasedCodes = InventoryEnum.getAllCodes();
        purchasedCodes.add(InventoryEnum.ROLEX.code);
        double price = priceCalculationsService.computeTotalPrice(purchasedCodes).getPrice();
        Assertions.assertThat(price).isEqualTo(360);
    }

    @Test
    public void shouldComputeFullPrice() {
        double price = priceCalculationsService.computeDiscount(1L, buildMichaelKors().get());
        Assertions.assertThat(price).isEqualTo(80);
    }

    @Test
    public void shouldComputeDiscount() {
        double price = priceCalculationsService.computeDiscount(3L, buildRolex().get());
        Assertions.assertThat(price).isEqualTo(200);
    }

    @Test
    public void shouldComputeMKDiscount() {
        double price = priceCalculationsService.computeDiscount(2L, buildMichaelKors().get());
        Assertions.assertThat(price).isEqualTo(120);
    }

    @Test
    public void shouldComputeRolexDiscount() {
        double price = priceCalculationsService.computeDiscount(3L, buildRolex().get());
        Assertions.assertThat(price).isEqualTo(200);
    }

    // No discount expected
    @Test
    public void shouldComputeCasioDiscount() {
        double price = priceCalculationsService.computeDiscount(10L, buildCasio().get());
        Assertions.assertThat(price).isEqualTo(300);
    }

    @Test
    public void shouldComputeSwatchDiscount() {
        double price = priceCalculationsService.computeDiscount(10L, buildSwatch().get());
        Assertions.assertThat(price).isEqualTo(500);
    }

    private Optional<Inventory> buildRolex() {
        return buildInventoryItem(InventoryEnum.ROLEX);
    }

    private Optional<Inventory> buildMichaelKors() {
        return buildInventoryItem(InventoryEnum.MICHAEL_KORS);
    }

    private Optional<Inventory> buildSwatch() {
        return buildInventoryItem(InventoryEnum.SWATCH);
    }

    private Optional<Inventory> buildCasio() {
        return buildInventoryItem(InventoryEnum.CASIO);
    }

    private Optional<Inventory> buildInventoryItem(InventoryEnum inventoryEnum) {
        Inventory inventory = new Inventory();
        inventory.setName(inventoryEnum.name);
        inventory.setCode(inventoryEnum.code);
        inventory.setUnitPrice(inventoryEnum.unitPrice);
        inventory.setDiscountUnits(inventoryEnum.discountUnits);
        inventory.setDiscountPercentage(inventoryEnum.discountPercentage);
        return Optional.of(inventory);
    }
}