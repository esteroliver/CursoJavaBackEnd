package com.example.user.repositories;

import com.example.user.models.UserModel;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID>{
    
}
