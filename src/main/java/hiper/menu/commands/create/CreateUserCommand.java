package hiper.menu.commands.create;

import hiper.dao.UserRepository;
import hiper.exceptions.EntityAlreadyExistsException;
import hiper.exceptions.MissingKeyGeneratorException;
import hiper.menu.commands.Command;
import hiper.menu.util.input.InputUserUtil;
import hiper.models.User;

public class CreateUserCommand implements Command {
    UserRepository userRepository;

    public CreateUserCommand(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void execute() throws MissingKeyGeneratorException, EntityAlreadyExistsException {
        User user = InputUserUtil.getUser();

        userRepository.create(user);
    }
}
