package com.mfirmanakbar.appstore.repository;

import com.mfirmanakbar.appstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
