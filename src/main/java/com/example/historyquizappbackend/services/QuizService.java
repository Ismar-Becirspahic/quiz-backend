package com.example.historyquizappbackend.services;
import com.example.historyquizappbackend.models.Question;
import com.example.historyquizappbackend.models.User;
import com.example.historyquizappbackend.repos.QuestionRepository;
import com.example.historyquizappbackend.repos.UserRepository;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public QuizService(QuestionRepository questionRepository, UserRepository userRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }
    @Transactional
    public List<Question> getQuestions() {
        List<Question> questions = questionRepository.findAll();
        questions.forEach(question -> Hibernate.initialize(question.getAnswers()));
        return questions;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public Question getQuestion(Long id) {
        Question question = questionRepository.findById(id).orElse(null);
        if (question != null) {
            Hibernate.initialize(question.getAnswers());
        }
        return question;
    }
    @Transactional
    public User updateUser(User updatedUser, long id) {
        User existingUser = getUser(id);
        existingUser.setNickname(updatedUser.getNickname());
        existingUser.setPoints(updatedUser.getPoints());
        return userRepository.save(existingUser);
    }

    private User getUser(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        throw new RuntimeException("User with that id does not exist.");
    }




}

