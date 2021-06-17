package hiper.dao.impl;

import hiper.dao.KeyGenerator;
import hiper.dao.QuizRepository;
import hiper.exceptions.EntityAlreadyExistsException;
import hiper.exceptions.MissingKeyGeneratorException;
import hiper.models.Gender;
import hiper.models.Quiz;
import hiper.models.Role;
import hiper.models.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class QuizRepositoryMemoryImplTest {
    private static final List<Quiz> SAMPLE_QUIZZES = List.of(
            new Quiz("peters Quiz",
                    new User(1L, "peter.johnson", "peterj@gmail.com",
                            "somePassword", Gender.MALE, Role.PLAYER),
                    "short quiz description", 3, "short"),
            new Quiz("geography Quiz",
                    new User(2L, "gamerGirl23", "jessica_peterson@email.com",
                            "password123",
                            Gender.FEMALE, Role.ADMINISTRATOR),
                    "quiz about geography", 5, "geo")
    );

    private static final long FIRST_QUIZ_ID = 1L;

    private static final User SAMPLE_USER = new User("gamerGirl23", "jessica_peterson@email.com", "password123",
            Gender.FEMALE, Role.ADMINISTRATOR);

    private static final Quiz NEW_QUIZ = new Quiz("French quiz", SAMPLE_USER,
            "quiz about the french language", 5, "french");

    private static final Quiz UPDATE_SECOND = new Quiz("Italian quiz", SAMPLE_USER,
            "quiz about the italian language", 5, "italian");

    private KeyGenerator<Long> keyGenerator;

    private QuizRepository quizRepository;

    private Quiz quiz;

    private Quiz updatedQuiz;

    @BeforeEach
    void setUp() {
        keyGenerator = new LongKeyGenerator();
        quizRepository = new QuizRepositoryMemoryImpl(keyGenerator);
    }

    @Test
    void findAll() {
        fillQuizRepository();
        List<Quiz> result = quizRepository.findAll();

        assertNotNull(result, "Fetched quizzes list is null.");
        assertEquals(SAMPLE_QUIZZES.size(), result.size());
    }

    @Test
    void findById() {
        fillQuizRepository();
        Optional<Quiz> result = quizRepository.findById(FIRST_QUIZ_ID);

        assertTrue(result.isPresent(), "Quiz is null.");
        assertEquals(FIRST_QUIZ_ID, result.get().getId(), "Quiz ID is wrong.");
        assertEquals(SAMPLE_QUIZZES.get(0), result.get());
    }

    @Test
    void create() {
        assertDoesNotThrow(() -> {
            quiz = quizRepository.create(NEW_QUIZ);
        }, "create() throws exception.");
        assertNotNull(quiz, "Quiz is null.");
        assertNotNull(quiz.getAuthor(), "Quiz author is null.");
        assertNotNull(quiz.getId(), "Quiz' ID is null.");
        assertEquals(NEW_QUIZ, quiz, "Created quiz does not match parameter entity.");
        assertEquals(FIRST_QUIZ_ID, quiz.getId(),"ID of quiz does not equal first item ID.");
    }

    @Test
    void update() throws MissingKeyGeneratorException, EntityAlreadyExistsException {
        quizRepository.create(NEW_QUIZ);

        assertDoesNotThrow(() -> {
            updatedQuiz = quizRepository.update(UPDATE_SECOND);
        });
        assertNotNull(updatedQuiz, "Updated quiz is null.");
        assertNotEquals(NEW_QUIZ, updatedQuiz, "Quiz was not updated.");
        assertEquals(FIRST_QUIZ_ID, updatedQuiz.getId());
        assertEquals(UPDATE_SECOND.getTitle(), updatedQuiz.getTitle(), "Titles do not match.");
        assertEquals(UPDATE_SECOND.getAuthor(), updatedQuiz.getAuthor(), "Authors do not match.");
        assertEquals(UPDATE_SECOND.getDescription(), updatedQuiz.getDescription(), "Descriptions do not match.");

    }

    @Test
    void deleteById() {
        fillQuizRepository();

        assertDoesNotThrow(() -> {
            quizRepository.deleteById(FIRST_QUIZ_ID);
        }, "deleteById() throws exception.");
        assertNotEquals(SAMPLE_QUIZZES.size(), quizRepository.findAll().size());
        assertEquals(SAMPLE_QUIZZES.size() - 1, quizRepository.findAll().size());
    }

    private void fillQuizRepository() {
        for (Quiz sampleQuiz : SAMPLE_QUIZZES) {
            try {
                quizRepository.create(sampleQuiz);
            } catch (MissingKeyGeneratorException e) {
                log.error("Missing key generator.");
            } catch (EntityAlreadyExistsException e) {
                log.error("Error adding quizzes to repository.");
            }
        }
    }
}
