package org.UPSkiller.repository;

import org.UPSkiller.Domain.User.PreferredRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreferredRoleRepository extends JpaRepository<PreferredRole, Long> {

    List<PreferredRole> findByJobPreferenceId(Long jobPreferenceId);
    
    void deleteByJobPreferenceId(Long jobPreferenceId);
}
