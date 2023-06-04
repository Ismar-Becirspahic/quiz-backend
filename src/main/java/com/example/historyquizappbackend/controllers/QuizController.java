package com.example.historyquizappbackend.controllers;
import com.example.historyquizappbackend.models.Question;
import com.example.historyquizappbackend.models.User;
import com.example.historyquizappbackend.services.QuizService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable Long id) {
        Question question = quizService.getQuestion(id);
        if (question == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(question);
    }
    @GetMapping
    public ResponseEntity<List<Question>> getQuestions() {
        List<Question> questions = quizService.getQuestions();
        return ResponseEntity.ok(questions);
    }
    @PostMapping
    public User addUser(@RequestBody User user) {
        return quizService.addUser(user);
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return this.quizService.getUsers();
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        User updatedUser = quizService.updateUser(user, id);
        return ResponseEntity.ok(updatedUser);
    }


}

