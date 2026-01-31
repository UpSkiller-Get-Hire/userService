package org.UPSkiller.Domain.User;

import jakarta.persistence.*;
import lombok.*;
import org.UPSkiller.Domain.User.Enums.ProfileStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="user_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id",nullable = false,unique = true)
    private String userId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    private String country;
    private String state;
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(name = "profile_status")
    private ProfileStatus profileStatus;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
