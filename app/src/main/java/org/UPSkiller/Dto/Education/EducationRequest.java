package org.UPSkiller.Dto.Education;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.UPSkiller.Domain.User.Enums.EducationLevel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EducationRequest {

    @NotNull(message = "Education level required")
    private EducationLevel educationLevel;

    @NotBlank(message = "Institution name required")
    private String institutionName;

    private String fieldOfStudy;

    @NotNull(message = "Starting year required")
    private Integer startYear;

    private Integer endYear;

    private boolean currentlyStudying;


}
