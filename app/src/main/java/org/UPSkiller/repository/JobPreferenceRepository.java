package org.UPSkiller.repository;

import org.UPSkiller.Domain.User.JobPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobPreferenceRepository extends JpaRepository<JobPreference, Long> {
    Optional<JobPreference> findByUserId(String userId);

    Boolean existsByUserId(String userId);

    void deleteByUserId(String userId);
}
