package com.yourcompany.sqlserverrestapi.repository;

import com.yourcompany.sqlserverrestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods can be added here
    List<User> findByName(String name);
    
    // Example of a custom query method
    List<User> findByEmailContaining(String emailDomain);
}