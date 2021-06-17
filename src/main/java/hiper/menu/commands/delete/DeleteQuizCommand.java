package hiper.menu.commands.delete;

import hiper.dao.QuizRepository;
import hiper.exceptions.EntityNotFoundException;
import hiper.menu.commands.Command;
import hiper.menu.util.input.InputIdUtil;

public class DeleteQuizCommand implements Command {
    private QuizRepository quizRepository;

    public DeleteQuizCommand(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public void execute() throws EntityNotFoundException {
        quizRepository.deleteById(InputIdUtil.getId());
    }
}
