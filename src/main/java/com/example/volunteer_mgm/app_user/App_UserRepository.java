package com.example.volunteer_mgm.app_user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface App_UserRepository  extends JpaRepository<App_User, Long> {

    Optional<App_User> findApp_UserByEmail(String email);
}
