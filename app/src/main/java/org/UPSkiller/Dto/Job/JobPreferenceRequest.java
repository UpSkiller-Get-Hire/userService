package org.UPSkiller.Dto.Job;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.UPSkiller.Domain.User.Enums.ExperienceLevel;
import org.UPSkiller.Domain.User.Enums.JobType;
import org.UPSkiller.Domain.User.Enums.WorkMode;
import org.UPSkiller.Domain.User.PreferredRole;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobPreferenceRequest {

    @NotBlank(message = "Job category is required")
    private String jobCategory;

    @NotNull(message = "Job type required")
    private JobType jobType;

    @NotNull(message = "Work mode required")
    private WorkMode workmode;

    private ExperienceLevel experienceLevel;

    private String availability;

    @NotEmpty(message = "At least one preference role required")
    private List<PreferredRoleRequest> preferredRole;
}
