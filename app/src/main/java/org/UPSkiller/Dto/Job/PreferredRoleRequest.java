package org.UPSkiller.Dto.Job;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreferredRoleRequest {
    @NotBlank(message = "Role name is required")
    private String roleName;
}
