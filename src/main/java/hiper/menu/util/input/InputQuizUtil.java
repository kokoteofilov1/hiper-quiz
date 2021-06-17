package hiper.menu.util.input;

import hiper.dao.UserRepository;
import hiper.models.Quiz;
import hiper.models.User;

import java.util.Optional;
import java.util.Scanner;

public final class InputQuizUtil {
    private static Scanner console = new Scanner(System.in);

    private InputQuizUtil() {
        throw new UnsupportedOperationException();
    }

    public static Quiz getQuiz(UserRepository userRepository) {
        Quiz quiz = new Quiz();

        System.out.print("title: ");
        String title = console.nextLine().trim();
        //TODO validate
        quiz.setTitle(title);

        System.out.printf("Which user created this quiz? Select user ID:%n" +
                "ID: ");
        long id = Long.parseLong(console.nextLine().trim());
        //TODO validate
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(quiz::setAuthor);

        System.out.print("description: ");
        String description = console.nextLine();
        //TODO validate
        quiz.setDescription(description);

        System.out.print("expectedDuration: ");
        int expectedDuration = Integer.parseInt(console.nextLine().trim());
        //TODO validate
        quiz.setExpectedDuration(expectedDuration);

        System.out.printf("Enter tags separated by commas:%n" +
                "tags: ");
        String tags = console.nextLine().trim();
        //TODO validate
        quiz.setTags(tags);

        return quiz;
    }

    public static Quiz getQuizWithId(UserRepository userRepository) {
        Quiz quiz = getQuiz(userRepository);

        quiz.setId(InputIdUtil.getId());

        return quiz;
    }
}
