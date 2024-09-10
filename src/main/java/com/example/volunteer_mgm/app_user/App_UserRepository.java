package com.example.volunteer_mgm.app_user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface App_UserRepository  extends JpaRepository<App_User, Long> {
}
