package hiper.menu.commands.create;

import hiper.dao.QuizRepository;
import hiper.dao.UserRepository;
import hiper.exceptions.EntityAlreadyExistsException;
import hiper.exceptions.MissingKeyGeneratorException;
import hiper.menu.commands.Command;
import hiper.menu.util.input.InputQuizUtil;
import hiper.models.Quiz;

public class CreateQuizCommand implements Command {
    QuizRepository quizRepository;
    UserRepository userRepository;

    public CreateQuizCommand(QuizRepository quizRepository, UserRepository userRepository) {
        this.quizRepository = quizRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void execute() throws MissingKeyGeneratorException, EntityAlreadyExistsException {
        Quiz quiz = InputQuizUtil.getQuiz(userRepository);

        quizRepository.create(quiz);
    }
}
