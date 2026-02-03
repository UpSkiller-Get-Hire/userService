package org.UPSkiller.Dto.Job;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.UPSkiller.Domain.User.Enums.ExperienceLevel;
import org.UPSkiller.Domain.User.Enums.JobType;
import org.UPSkiller.Domain.User.Enums.WorkMode;

import java.util.List;

@Getter
@Setter
@Builder
public class JobPreferenceResponse {
    private String jobCategory;
    private JobType jobType;
    private WorkMode workmode;
    private ExperienceLevel experienceLevel;
    private String availability;

    private List<String> preferredRoles;

}
