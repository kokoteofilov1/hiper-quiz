package hiper.dao;

import hiper.models.Quiz;

import java.util.List;

public interface QuizRepository extends Repository<Long, Quiz> {
    List<Quiz> findByTitle(String title);
    List<Quiz> findByDescription(String description);
    List<Quiz> findByTags(String tags);
    List<Quiz> findByExpectedDuration(int expectedDuration);
}
