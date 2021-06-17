package hiper.menu.commands.update;

import hiper.dao.UserRepository;
import hiper.exceptions.EntityNotFoundException;
import hiper.menu.commands.Command;
import hiper.menu.util.input.InputUserUtil;
import hiper.models.User;

public class UpdateUserCommand implements Command {
    private UserRepository userRepository;

    public UpdateUserCommand(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void execute() throws EntityNotFoundException {
        User user = InputUserUtil.getUserWithId();

        userRepository.update(user);
    }
}
