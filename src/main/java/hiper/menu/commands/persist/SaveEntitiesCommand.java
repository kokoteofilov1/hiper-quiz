package hiper.menu.commands.persist;

import hiper.dao.*;
import hiper.exceptions.EntityAlreadyExistsException;
import hiper.exceptions.EntityNotFoundException;
import hiper.exceptions.MissingKeyGeneratorException;
import hiper.menu.commands.Command;
import hiper.models.AllCollections;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

@Slf4j
public class SaveEntitiesCommand implements Command {
    private UserRepository userRepository;
    private QuizRepository quizRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private QuizResultRepository quizResultRepository;
    private OutputStream out;

    public SaveEntitiesCommand(OutputStream out, UserRepository userRepository, QuizRepository quizRepository,
                               QuestionRepository questionRepository, AnswerRepository answerRepository,
                               QuizResultRepository quizResultRepository) {
        this.userRepository = userRepository;
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.quizResultRepository = quizResultRepository;
        this.out = out;
    }

    @Override
    public void execute() {
        AllCollections allCollections = new AllCollections(userRepository.findAll(), quizRepository.findAll(),
                questionRepository.findAll(), answerRepository.findAll(), quizResultRepository.findAll());

        try (ObjectOutputStream outputStream = new ObjectOutputStream(out)) {
            outputStream.writeObject(allCollections);
        } catch (IOException e) {
            log.error("Error writing collections to file", e);
        }

    }
}