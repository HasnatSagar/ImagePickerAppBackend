package com.userprofile.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userprofile.main.model.UserProfileInfo;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileInfo, Long> {

}
