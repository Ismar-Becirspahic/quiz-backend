package com.example.historyquizappbackend.repos;
import com.example.historyquizappbackend.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
