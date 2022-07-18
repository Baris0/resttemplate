package com.binance.restTemplate.repository;

import com.binance.restTemplate.model.AvgPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvgPriceRepository extends JpaRepository<AvgPrice, Integer> {
}
