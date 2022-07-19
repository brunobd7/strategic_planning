package com.dantas.strategicplanning.repository;

import com.dantas.strategicplanning.model.Indicator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndicatorRepository extends JpaRepository<Long, Indicator> {
}
