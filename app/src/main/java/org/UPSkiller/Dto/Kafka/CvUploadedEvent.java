package org.UPSkiller.Dto.Kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvUploadedEvent {
    private String userId;
    private String fileName;
    private String bucket;
    private long uploadedAt;
}
