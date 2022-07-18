package com.binance.restTemplate.service;

import com.binance.restTemplate.dto.AvgPriceDto;
import com.binance.restTemplate.dto.converter.AvgPriceDtoConverter;
import com.binance.restTemplate.model.AvgPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BitcoinService {

    private final RestTemplate restTemplate;
    private final AvgPriceDtoConverter converter;

    public AvgPriceDto getAvgPrice(String symbol) {
        AvgPrice avgPrice = restTemplate.getForObject("https://api1.binance.com/api/v3/avgPrice?symbol="+symbol, AvgPrice.class);
        avgPrice.setSymbol(symbol);
        return converter.convert(avgPrice);
    }
}
