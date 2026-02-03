package org.UPSkiller.Dto.Profile;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserProfileResponse {

    private String userid;
    private String fullName;
    private String profilePictureUrl;

    private String country;
    private String state;
    private String city;

    private String profileStatus;
}
