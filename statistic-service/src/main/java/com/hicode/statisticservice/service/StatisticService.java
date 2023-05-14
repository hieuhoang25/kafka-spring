package com.hicode.statisticservice.service;

import com.hicode.statisticservice.dto.Statistic;
import com.hicode.statisticservice.repository.StatisticRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class StatisticService {

    private StatisticRepository repository;

    @KafkaListener(topics = "statistic", id = "statisticGroup")
    @RetryableTopic(attempts = "5", dltTopicSuffix = "-dlt",backoff = @Backoff(delay = 2_000 , multiplier = 2))
    public void listen(Statistic statistic){
        log.info("Received: {} ", statistic);
//        repository.save(statistic);
        throw new RuntimeException();
    }

    @KafkaListener(topics = "statistic-dlt", id = "dltGroup")
    public void dltListen(Statistic statistic){
        log.info("Received statistic: {} ", statistic);
        //save to database to re-send to queue
//        repository.save(statistic);
    }

//    @KafkaListener(topics = "statistic.DLT", id = "dltGroup")
//    public void dltListen(Statistic statistic){
//        log.info("Received statistic: {} ", statistic);
//        //save to database to re-send to queue
////        repository.save(statistic);
//    }
}
