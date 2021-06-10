package hiper.menu;

import hiper.exceptions.EntityAlreadyExistsException;
import hiper.exceptions.EntityNotFoundException;
import hiper.exceptions.MissingKeyGeneratorException;

public class Main {
    public static void main(String[] args) throws MissingKeyGeneratorException, EntityAlreadyExistsException, EntityNotFoundException {
        ConsoleMenu menu = new ConsoleMenu();
        while (true) {
            menu.run();
        }
    }
}
