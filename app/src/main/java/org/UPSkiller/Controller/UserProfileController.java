package org.UPSkiller.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.UPSkiller.Domain.User.UserCv;
import org.UPSkiller.Dto.Education.EducationRequest;
import org.UPSkiller.Dto.Education.EducationResponse;
import org.UPSkiller.Dto.Job.JobPreferenceRequest;
import org.UPSkiller.Dto.Job.JobPreferenceResponse;
import org.UPSkiller.Dto.Profile.UserProfileRequest;
import org.UPSkiller.Dto.Profile.UserProfileResponse;
import org.UPSkiller.Service.UserCvService;
import org.UPSkiller.Service.UserProfileService;
import org.UPSkiller.repository.UserCvRepository;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/profile")
@RequiredArgsConstructor
@Validated
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final UserCvService userCvService;
    private final UserCvRepository userCvRepository;

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

    @GetMapping("/education")
    public ResponseEntity<List<EducationResponse>> getEducation(
            @RequestHeader("X-USER-ID") String userId
    ){
        return ResponseEntity.ok(userProfileService.getEducation(userId));
    }

    @GetMapping("/job-preference")
    public ResponseEntity<List<JobPreferenceResponse>> getJobPreference(
            @RequestHeader("X-USER-ID") String userId
    ){
        return ResponseEntity.ok(Collections.singletonList(userProfileService.getJobPreference(userId)));
    }

    @PostMapping("/cv")
    public ResponseEntity<Void> saveCv(
            @RequestHeader("X-USER-ID") String userId,
            @RequestParam("file") MultipartFile file
    ) throws Exception{

        String fileName = userCvService.uploadCv(userId,file);

        userCvRepository.findByUserId(userId).ifPresent(userCvRepository::delete);

        userCvRepository.save(
                new UserCv(null,userId,fileName, LocalDateTime.now()) // here fileName will be replaced with url
        );

        return ResponseEntity.ok().build();

    }

    //internal route used by frontend
    @GetMapping("/me")
    public Map<String, String> me(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader(value = "X-User-Role", required = false) String role
    ) {
        return Map.of(
                "userId", userId,
                "role", role
        );
    }

}
