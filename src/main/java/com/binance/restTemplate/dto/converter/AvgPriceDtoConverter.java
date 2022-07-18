package com.binance.restTemplate.dto.converter;

import com.binance.restTemplate.dto.AvgPriceDto;
import com.binance.restTemplate.model.AvgPrice;
import org.springframework.stereotype.Component;

@Component
public class AvgPriceDtoConverter {

    public AvgPriceDto convert(AvgPrice avgPrice) {
        return new AvgPriceDto(
                avgPrice.getMins(),
                avgPrice.getPrice(),
                avgPrice.getSymbol()
        );
    }
}
