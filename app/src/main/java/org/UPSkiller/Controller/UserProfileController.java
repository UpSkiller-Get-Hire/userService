package org.UPSkiller.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.UPSkiller.Dto.Education.EducationRequest;
import org.UPSkiller.Dto.Job.JobPreferenceRequest;
import org.UPSkiller.Dto.Profile.UserProfileRequest;
import org.UPSkiller.Dto.Profile.UserProfileResponse;
import org.UPSkiller.Service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/profile")
@RequiredArgsConstructor
@Validated
public class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping
    public ResponseEntity<UserProfileResponse> getProfile(
            @RequestHeader("X-USER-ID") String userId
    ){
        return ResponseEntity.ok(userProfileService.getProfile(userId));
    }

    @PostMapping
    public ResponseEntity<UserProfileResponse> saveProfile(
            @RequestHeader("X-USER-ID") String userId,
            @Valid @RequestBody UserProfileRequest request
    ){
       return ResponseEntity.ok(userProfileService.saveOrUpdateProfile(userId, request));
    }

    @PostMapping("/education")
    public ResponseEntity<Void> saveEducation(
            @RequestHeader("X-USER-ID") String userId,
            @Valid @RequestBody List<EducationRequest> request
    ){
        userProfileService.saveEducation(userId, request);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/job-preference")
    public ResponseEntity<Void> saveJobPreference(
            @RequestHeader("X-USER-ID") String userId,
            @Valid @RequestBody JobPreferenceRequest request
    ){
        userProfileService.saveJobPreference(userId, request);
        return ResponseEntity.ok().build();
    }
}
