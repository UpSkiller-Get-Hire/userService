package org.UPSkiller.Domain.User;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_cv")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;

    @Column(name = "cv_url",nullable = false)
    private String cvUrl;

    @Column(name = "uploaded_at")
    private LocalDateTime uploadedAt;

}
