package com.example.historyquizappbackend.repos;
import com.example.historyquizappbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
