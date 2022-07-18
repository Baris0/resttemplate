package com.binance.restTemplate.service;

import com.binance.restTemplate.dto.AvgPriceDto;
import com.binance.restTemplate.dto.converter.AvgPriceDtoConverter;
import com.binance.restTemplate.model.AvgPrice;
import com.binance.restTemplate.repository.AvgPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BitcoinService {

    private final RestTemplate restTemplate;
    private final AvgPriceDtoConverter converter;
    private final AvgPriceRepository avgPriceRepository;

    public AvgPriceDto getAvgPrice(String symbol) {
        AvgPrice avgPrice = restTemplate.getForObject("https://api1.binance.com/api/v3/avgPrice?symbol="+symbol, AvgPrice.class);
        avgPrice.setSymbol(symbol);
        avgPriceRepository.save(avgPrice);
        return converter.convert(avgPrice);
    }

    public List<AvgPriceDto> getAllAvgPrice() {
        return avgPriceRepository.findAll().stream().map(converter::convert).collect(Collectors.toList());
    }
}
