package org.UPSkiller.Domain.User;

import jakarta.persistence.*;
import lombok.*;
import org.UPSkiller.Domain.User.Enums.ExperienceLevel;
import org.UPSkiller.Domain.User.Enums.JobType;
import org.UPSkiller.Domain.User.Enums.WorkMode;

@Entity
@Table(name = "job_preference")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id",nullable = false,unique = true)
    private String userId;

    private String jobCategory;

    @Enumerated(value = EnumType.STRING)
    private JobType jobType;

    @Enumerated(value = EnumType.STRING)
    private WorkMode  workMode;

    @Enumerated(value = EnumType.STRING)
    private ExperienceLevel  experienceLevel;

    private String availability;

}
