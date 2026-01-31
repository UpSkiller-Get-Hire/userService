package org.UPSkiller.Domain.User;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "preferred_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreferredRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_preference_id")
    private Long jobPreferenceId;

    @Column(name = "role_name")
    private String roleName;

}
