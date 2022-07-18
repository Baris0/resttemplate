package com.binance.restTemplate.controller;

import com.binance.restTemplate.dto.AvgPriceDto;
import com.binance.restTemplate.service.BitcoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/bitcoin")
@RequiredArgsConstructor
public class BitcoinController {

    private final BitcoinService bitcoinService;

    @GetMapping("/avgPrice/{symbol}")
    public ResponseEntity<AvgPriceDto> getAvgPrice(@PathVariable("symbol") String symbol) {
        return ResponseEntity.ok(bitcoinService.getAvgPrice(symbol));
    }

    @GetMapping("/get-avgPrice")
    public List<AvgPriceDto> getAllAvgPrice() {
        return bitcoinService.getAllAvgPrice();
    }
}
