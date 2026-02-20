package org.UPSkiller.Service;

import lombok.RequiredArgsConstructor;
import org.UPSkiller.Dto.Kafka.CvUploadedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CvEventProducer {

    private final KafkaTemplate<String, CvUploadedEvent> kafkaTemplate;

    public void sendEvent(String userId,String fileName,String bucket){
        CvUploadedEvent event = new CvUploadedEvent(userId,fileName,bucket,System.currentTimeMillis());

        kafkaTemplate.send("cv-uploaded-topic", userId, event);
    }
}
