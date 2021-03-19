package com.ae.adq.maha.interview.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class InventoryDto {

    private double unitPrice;
    private String code, name, discountPercentage, units;

}
