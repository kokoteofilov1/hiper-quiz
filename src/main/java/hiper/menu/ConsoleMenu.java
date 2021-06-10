package hiper.menu;

import hiper.dao.AnswerRepository;
import hiper.dao.QuestionRepository;
import hiper.dao.QuizRepository;
import hiper.dao.UserRepository;
import hiper.dao.impl.*;
import hiper.exceptions.EntityAlreadyExistsException;
import hiper.exceptions.EntityNotFoundException;
import hiper.exceptions.MissingKeyGeneratorException;
import hiper.menu.commands.*;
import hiper.menu.commands.create.CreateQuizCommand;
import hiper.menu.commands.create.CreateUserCommand;
import hiper.menu.commands.delete.DeleteQuizCommand;
import hiper.menu.commands.delete.DeleteUserCommand;
import hiper.menu.commands.read.ReadAllQuizzesCommand;
import hiper.menu.commands.read.ReadAllUsersCommand;
import hiper.menu.commands.update.UpdateQuizCommand;
import hiper.menu.commands.update.UpdateUserCommand;
import hiper.menu.util.input.InputMenuCommandUtil;

public class ConsoleMenu {
    UserRepository userRepository = new UserRepositoryMemoryImpl(new LongKeyGenerator());
    QuizRepository quizRepository = new QuizRepositoryMemoryImpl(new LongKeyGenerator());
    QuestionRepository questionRepository = new QuestionRepositoryMemoryImpl(new LongKeyGenerator());
    AnswerRepository answerRepository = new AnswerRepositoryMemoryImpl(new LongKeyGenerator());

    public void executeMenuCommand(Command command) throws MissingKeyGeneratorException, EntityAlreadyExistsException, EntityNotFoundException {
        command.execute();
    }

    public void run() throws MissingKeyGeneratorException, EntityAlreadyExistsException, EntityNotFoundException {
        MenuCommandProps command = InputMenuCommandUtil.getCommand();

        switch (command.getEntityName()) {
            case "USER":
                switch (command.getAction().name()) {
                    case "CREATE":
                        executeMenuCommand(new CreateUserCommand(userRepository));
                        break;
                    case "READ":
                        executeMenuCommand(new ReadAllUsersCommand(userRepository));
                        break;
                    case "UPDATE":
                        executeMenuCommand(new UpdateUserCommand(userRepository));
                        break;
                    case "DELETE":
                        executeMenuCommand(new DeleteUserCommand(userRepository));
                        break;
                }
                break;
            case "QUIZ":
                switch (command.getAction().name()) {
                    case "CREATE":
                        executeMenuCommand(new CreateQuizCommand(quizRepository, userRepository));
                        break;
                    case "READ":
                        executeMenuCommand(new ReadAllQuizzesCommand(quizRepository));
                        break;
                    case "UPDATE":
                        executeMenuCommand(new UpdateQuizCommand(quizRepository, userRepository));
                        break;
                    case "DELETE":
                        executeMenuCommand(new DeleteQuizCommand(quizRepository));
                        break;
                }
        }
    }
}
