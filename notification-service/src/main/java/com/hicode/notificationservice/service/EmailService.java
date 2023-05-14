package com.hicode.notificationservice.service;

import com.hicode.notificationservice.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    @Async
    public void sendEmail(MessageDTO messageDTO){
        log.info("Start... Sending email");
        log.info("Send item: {}", messageDTO);
    }
}
