package com.hicode.notificationservice.service;

import com.hicode.notificationservice.dto.MessageDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class MessageService {
    private EmailService emailService;

    @KafkaListener(id = "notificationGroup", topics = "notification")
    public void listen(MessageDTO messageDTO){
        log.info("Received",messageDTO.getTo());
        emailService.sendEmail(messageDTO);
    }
}
