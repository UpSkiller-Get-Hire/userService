package org.UPSkiller.Service;

import org.UPSkiller.Dto.Education.EducationRequest;
import org.UPSkiller.Dto.Education.EducationResponse;
import org.UPSkiller.Dto.Job.JobPreferenceRequest;
import org.UPSkiller.Dto.Job.JobPreferenceResponse;
import org.UPSkiller.Dto.Profile.UserProfileRequest;
import org.UPSkiller.Dto.Profile.UserProfileResponse;

import java.util.List;

public interface UserProfileService {
    UserProfileResponse getProfile(String userId);

    UserProfileResponse saveOrUpdateProfile(String userId, UserProfileRequest request);

    void saveEducation(String userId, List<EducationRequest> educationRequests);

    void saveJobPreference(String userId, JobPreferenceRequest request);

    List<EducationResponse> getEducation(String userId);

    JobPreferenceResponse getJobPreference(String userId);
}
