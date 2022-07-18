package com.binance.restTemplate.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AvgPrice {

    private Integer mins;

    private BigDecimal price;

    private String symbol;
}
