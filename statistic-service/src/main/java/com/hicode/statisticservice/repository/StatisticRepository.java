package com.hicode.statisticservice.repository;

import com.hicode.statisticservice.dto.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepository extends JpaRepository<Statistic, Integer> {
}
