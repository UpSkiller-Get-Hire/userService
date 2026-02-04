package org.UPSkiller.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.UPSkiller.Domain.User.Education;
import org.UPSkiller.Domain.User.Enums.ProfileStatus;
import org.UPSkiller.Domain.User.JobPreference;
import org.UPSkiller.Domain.User.PreferredRole;
import org.UPSkiller.Domain.User.UserProfile;
import org.UPSkiller.Dto.Education.EducationRequest;
import org.UPSkiller.Dto.Job.JobPreferenceRequest;
import org.UPSkiller.Dto.Profile.UserProfileRequest;
import org.UPSkiller.Dto.Profile.UserProfileResponse;
import org.UPSkiller.Service.UserProfileService;
import org.UPSkiller.repository.EducationRepository;
import org.UPSkiller.repository.JobPreferenceRepository;
import org.UPSkiller.repository.PreferredRoleRepository;
import org.UPSkiller.repository.UserProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final EducationRepository educationRepository;
    private final JobPreferenceRepository jobPreferenceRepository;
    private final PreferredRoleRepository preferredRoleRepository;



    @Override
    public UserProfileResponse getProfile(String userId) {
        UserProfile profile = userProfileRepository.findByUserId(userId).orElseThrow(
                ()->new RuntimeException("Profile not found"));

        return UserProfileResponse.builder()
                .userid(profile.getUserId())
                .fullName(profile.getFullName())
                .profilePictureUrl(profile.getProfilePictureUrl())
                .country(profile.getCountry())
                .state(profile.getState())
                .city(profile.getCity())
                .profileStatus(profile.getProfilePictureUrl())
                .build();

    }

    @Override
    public UserProfileResponse saveOrUpdateProfile(String userId, UserProfileRequest request) {
        UserProfile profile = userProfileRepository.findByUserId(userId)
                .orElse(
                        UserProfile.builder()
                                .userId(userId)
                                .profileStatus(ProfileStatus.INCOMPLETE)
                                .build());

        profile.setFullName(request.getFullName());
        profile.setProfilePictureUrl(request.getProfilePictureUrl());
        profile.setCountry(request.getCountry());
        profile.setState(request.getState());
        profile.setCity(request.getCity());

        userProfileRepository.save(profile);

        return getProfile(userId);
    }

    @Override
    public void saveEducation(String userId, List<EducationRequest> educationRequests) {
        educationRepository.deleteByUserId(userId);

        List<Education> educations = educationRequests.stream()
                .map(req-> Education.builder()
                        .userid(userId)
                        .educationLevel(req.getEducationLevel())
                        .institutionName(req.getInstitutionName())
                        .filedOfStudy(req.getFieldOfStudy())
                        .startYear(req.getStartYear())
                        .endYear(req.getEndYear())
                        .currentlyStudying(req.isCurrentlyStudying())
                        .build()

                ).toList();
        educationRepository.saveAll(educations);
    }

    @Override
    public void saveJobPreference(String userId, JobPreferenceRequest request) {
        jobPreferenceRepository.deleteByUserId(userId);

        JobPreference jobPreference = JobPreference.builder()
                .userId(userId)
                .jobCategory(request.getJobCategory())
                .jobType(request.getJobType())
                .workMode(request.getWorkmode())
                .experienceLevel(request.getExperienceLevel())
                .availability(request.getAvailability())
                .build();

        JobPreference saved = jobPreferenceRepository.save(jobPreference);

        preferredRoleRepository.deleteByJobPreferenceId(saved.getId());

        List<PreferredRole> roles = request.getPreferredRole().stream()
                .map(r->PreferredRole.builder()
                        .jobPreferenceId(saved.getId())
                        .roleName(r.getRoleName())
                        .build()
                ).toList();

        preferredRoleRepository.saveAll(roles);
    }
}
