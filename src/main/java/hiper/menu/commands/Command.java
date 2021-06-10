package hiper.menu.commands;

import hiper.exceptions.EntityAlreadyExistsException;
import hiper.exceptions.EntityNotFoundException;
import hiper.exceptions.MissingKeyGeneratorException;

public interface Command {
    void execute() throws MissingKeyGeneratorException, EntityAlreadyExistsException, EntityNotFoundException;
}
