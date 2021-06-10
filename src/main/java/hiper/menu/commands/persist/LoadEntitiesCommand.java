package hiper.menu.commands.persist;

import hiper.dao.*;
import hiper.exceptions.EntityAlreadyExistsException;
import hiper.exceptions.EntityNotFoundException;
import hiper.exceptions.MissingKeyGeneratorException;
import hiper.menu.commands.Command;
import hiper.models.AllCollections;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

@Slf4j
public class LoadEntitiesCommand implements Command {
    private UserRepository userRepository;
    private QuizRepository quizRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private QuizResultRepository quizResultRepository;
    private InputStream in;

    public LoadEntitiesCommand(InputStream in, UserRepository userRepository, QuizRepository quizRepository,
                               QuestionRepository questionRepository, AnswerRepository answerRepository,
                               QuizResultRepository quizResultRepository) {
        this.userRepository = userRepository;
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.quizResultRepository = quizResultRepository;
        this.in = in;
    }

    @Override
    public void execute() throws MissingKeyGeneratorException, EntityAlreadyExistsException, EntityNotFoundException {
        try (ObjectInputStream objectStream = new ObjectInputStream(in)) {
            AllCollections allCollections = (AllCollections) objectStream.readObject();
            userRepository.createBatch(allCollections.getUsers());
            quizRepository.createBatch(allCollections.getQuizzes());
            questionRepository.createBatch(allCollections.getQuestions());
            answerRepository.createBatch(allCollections.getAnswers());
            quizResultRepository.createBatch(allCollections.getQuizResults());
        } catch (IOException | ClassNotFoundException e) {
            log.error("Error reading collections from file.");
        } catch (EntityAlreadyExistsException e) {
            log.error("Error adding entities to repository");
        }
    }
}
