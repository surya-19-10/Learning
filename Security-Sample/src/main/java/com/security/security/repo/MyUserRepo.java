package com.security.security.repo;

import com.security.security.core.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String s);
}
