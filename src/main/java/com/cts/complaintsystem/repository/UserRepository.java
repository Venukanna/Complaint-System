package com.cts.complaintsystem.repository;



import com.cts.complaintsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

