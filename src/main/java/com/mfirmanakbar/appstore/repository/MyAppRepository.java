package com.mfirmanakbar.appstore.repository;

import com.mfirmanakbar.appstore.model.MyApp;
import com.mfirmanakbar.appstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyAppRepository extends JpaRepository<MyApp, Long> {
    List<MyApp> findByUserId(String userId);
}
