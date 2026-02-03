package org.UPSkiller.Dto.Education;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EducationResponse {

    private String educationLevel;
    private String instituteName;
    private String fieldOfStudy;

    private Integer startYear;
    private Integer endYear;

    private Boolean currentlyStudying;
}
