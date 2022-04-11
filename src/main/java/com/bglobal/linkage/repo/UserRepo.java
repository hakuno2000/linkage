package com.bglobal.linkage.repo;

import com.bglobal.linkage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    User findUserByUsername(String username);
}
