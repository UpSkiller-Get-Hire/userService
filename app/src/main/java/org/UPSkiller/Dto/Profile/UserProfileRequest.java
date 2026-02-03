package org.UPSkiller.Dto.Profile;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileRequest {

    @NotBlank(message = "Full name required")
    private String fullName;

    private String profilePictureUrl;

    @NotBlank(message = "Country required")
    private String country;

    @NotBlank(message = "State required")
    private String state;

    @NotBlank(message = "City required")
    private String city;
}
