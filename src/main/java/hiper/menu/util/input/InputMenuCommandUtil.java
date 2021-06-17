package hiper.menu.util.input;

import hiper.menu.Action;
import hiper.menu.MenuCommandProps;
import hiper.menu.util.validation.ValidateMenuCommandUtil;

import java.util.Scanner;

public final class InputMenuCommandUtil {
    private static Scanner console = new Scanner(System.in);

    private InputMenuCommandUtil() {
        throw new UnsupportedOperationException();
    }

    private static String getCommandAction() {
        //prompt user to enter command action
        System.out.printf("What action do you want to perform on the Entity?%n" +
                "Choose from the following: [CREATE, READ, UPDATE, DELETE]%n" +
                "action: ");

        //read command action from user input
        String commandAction = console.nextLine().trim().toUpperCase();

        return commandAction;
    }

    private static String getCommandEntity() {
        //prompt user to enter command entity
        System.out.printf("Which entity do you want to perform this action on?%n" +
                "Choose from the following: [User, Player, Administrator, Quiz, Question, Answer]%n" +
                "entity: ");

        //read command entity from user input
        String commandEntity = console.nextLine().trim().toUpperCase();

        return commandEntity;
    }

    public static MenuCommandProps getCommand() {
        String commandAction = getCommandAction();
        while (!ValidateMenuCommandUtil.validateAction(commandAction)) {
            commandAction = getCommandAction();
        }

        String commandEntity = getCommandEntity();
        while (!ValidateMenuCommandUtil.validateEntity(commandEntity)) {
            commandEntity = getCommandEntity();
        }

        return new MenuCommandProps(Action.valueOf(commandAction), commandEntity);
    }
}
