package hiper.menu.commands.delete;

import hiper.dao.UserRepository;
import hiper.exceptions.EntityNotFoundException;
import hiper.menu.commands.Command;
import hiper.menu.util.input.InputIdUtil;

public class DeleteUserCommand implements Command {
    UserRepository userRepository;

    public DeleteUserCommand(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void execute() throws EntityNotFoundException {
        userRepository.deleteById(InputIdUtil.getId());
    }
}
