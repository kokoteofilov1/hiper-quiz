package hiper.menu.commands.read;

import hiper.dao.UserRepository;
import hiper.exceptions.EntityAlreadyExistsException;
import hiper.exceptions.MissingKeyGeneratorException;
import hiper.menu.commands.Command;
import hiper.menu.util.print.Alignment;
import hiper.menu.util.print.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class ReadAllUsersCommand implements Command {
    private UserRepository userRepository;

    public ReadAllUsersCommand(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void execute() throws MissingKeyGeneratorException, EntityAlreadyExistsException {
        List<PrintUtil.ColumnDescriptor> userColumns = new ArrayList<>(List.of(
                new PrintUtil.ColumnDescriptor("id", "ID", 5, Alignment.CENTER),
                new PrintUtil.ColumnDescriptor("username", "Username", 20, Alignment.LEFT),
                new PrintUtil.ColumnDescriptor("email", "Email", 20, Alignment.LEFT),
                new PrintUtil.ColumnDescriptor("gender", "Gender", 7, Alignment.CENTER),
                new PrintUtil.ColumnDescriptor("role", "Role", 13, Alignment.CENTER)
        ));

        String usersTable = PrintUtil.formatTable(userColumns, userRepository.findAll(), "Users List:");

        System.out.println(usersTable);
    }
}
