package org.UPSkiller.Domain.User;

import jakarta.persistence.*;
import lombok.*;
import org.UPSkiller.Domain.User.Enums.EducationLevel;

@Entity
@Table(name = "education")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id",nullable = false,unique = true)
    private String userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "education_level")
    private EducationLevel educationLevel;

    private String institutionName;
    private String fieldOfStudy;

    private Integer startYear;
    private Integer endYear;

    private Boolean currentlyStudying;

}
