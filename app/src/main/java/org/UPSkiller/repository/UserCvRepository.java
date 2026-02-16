package org.UPSkiller.repository;

import org.UPSkiller.Domain.User.UserCv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCvRepository extends JpaRepository<UserCv, Long> {
    Optional<UserCv> findByUserId(String userId);
}
