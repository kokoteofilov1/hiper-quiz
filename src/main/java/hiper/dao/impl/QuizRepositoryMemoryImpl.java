package hiper.dao.impl;

import hiper.dao.KeyGenerator;
import hiper.dao.QuizRepository;
import hiper.models.Quiz;

import java.util.List;
import java.util.stream.Collectors;

public class QuizRepositoryMemoryImpl extends RepositoryMemoryImpl<Long, Quiz> implements QuizRepository {
    public QuizRepositoryMemoryImpl() {
    }

    public QuizRepositoryMemoryImpl(KeyGenerator<Long> keyGenerator) {
        super(keyGenerator);
    }

    @Override
    public List<Quiz> findByTitle(String title) {
        return findAll().stream().filter(quiz -> quiz.getTitle().equals(title)).collect(Collectors.toList());
    }

    @Override
    public List<Quiz> findByDescription(String description) {
        return null;
    }

    @Override
    public List<Quiz> findByTags(String tags) {
        return null;
    }

    @Override
    public List<Quiz> findByExpectedDuration(int expectedDuration) {
        return findAll().stream().filter(quiz -> quiz.getExpectedDuration() < expectedDuration).collect(Collectors.toList());
    }
}
