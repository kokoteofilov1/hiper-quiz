package hiper.menu.commands.update;

import hiper.dao.QuizRepository;
import hiper.dao.UserRepository;
import hiper.exceptions.EntityAlreadyExistsException;
import hiper.exceptions.EntityNotFoundException;
import hiper.exceptions.MissingKeyGeneratorException;
import hiper.menu.commands.Command;
import hiper.menu.util.input.InputQuizUtil;
import hiper.models.Quiz;

public class UpdateQuizCommand implements Command {
    private QuizRepository quizRepository;
    private UserRepository userRepository;

    public UpdateQuizCommand(QuizRepository quizRepository, UserRepository userRepository) {
        this.quizRepository = quizRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void execute() throws MissingKeyGeneratorException, EntityAlreadyExistsException, EntityNotFoundException {
        Quiz quiz = InputQuizUtil.getQuizWithId(userRepository);

        quizRepository.update(quiz);
    }
}
