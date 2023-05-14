package com.hicode.accountservice.controller;

import com.hicode.accountservice.dto.AccountDTO;
import com.hicode.accountservice.dto.MessageDTO;
import com.hicode.accountservice.dto.StatisticDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
@Slf4j
public class AccountController {
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/new")
    public AccountDTO create(@RequestBody AccountDTO accountDTO){
        StatisticDTO statisticDTO = new StatisticDTO("Account "+accountDTO.getEmail()+ " is created", new Date());
        //send notification
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setTo(accountDTO.getEmail());
        messageDTO.setToName(accountDTO.getName());
        messageDTO.setSubject("Welcome to Hicode");
        messageDTO.setContent("I am Hieu");
        kafkaTemplate.send("notification",messageDTO);
        kafkaTemplate.send("statistic",statisticDTO)
                .thenApply(stringObjectSendResult -> {
                    log.info("success: {}",stringObjectSendResult);
                    return stringObjectSendResult;
                })
                .exceptionally(ex->{
                    log.info("error: {}", ex);
                    return null;
                });
        // add callback
        //kaf

        return accountDTO;
    }

}
