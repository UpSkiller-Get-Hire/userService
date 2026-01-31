package org.UPSkiller.repository;

import org.UPSkiller.Domain.User.UserCv;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCVRepository {
    Optional<UserCv> findByUserId(String userId);

    boolean existsByUserId(String userId);

    void deleteByUserId(String userId);
}
