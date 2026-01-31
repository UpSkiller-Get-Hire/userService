package org.UPSkiller.repository;

import org.UPSkiller.Domain.User.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findByUserId(String userId);

    void deleteByUserId(String userId);
}

