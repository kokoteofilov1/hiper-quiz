package hiper.menu.commands.read;

import hiper.dao.QuizRepository;
import hiper.exceptions.EntityAlreadyExistsException;
import hiper.exceptions.EntityNotFoundException;
import hiper.exceptions.MissingKeyGeneratorException;
import hiper.menu.commands.Command;
import hiper.menu.util.print.Alignment;
import hiper.menu.util.print.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class ReadAllQuizzesCommand implements Command {
    QuizRepository quizRepository;

    public ReadAllQuizzesCommand(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public void execute() throws MissingKeyGeneratorException, EntityAlreadyExistsException, EntityNotFoundException {
        List<PrintUtil.ColumnDescriptor> quizColumns = new ArrayList<>(List.of(
                new PrintUtil.ColumnDescriptor("id", "ID", 5, Alignment.CENTER),
                new PrintUtil.ColumnDescriptor("author", "Author", 20, Alignment.LEFT),
                new PrintUtil.ColumnDescriptor("description", "Description", 50, Alignment.LEFT),
                new PrintUtil.ColumnDescriptor("expectedDuration", "Expected duration", 7, Alignment.CENTER),
                new PrintUtil.ColumnDescriptor("tags", "Tags", 30, Alignment.CENTER)
        ));

        String quizzesTable = PrintUtil.formatTable(quizColumns, quizRepository.findAll(), "Quizzes List:");

        System.out.println(quizzesTable);
    }
}
