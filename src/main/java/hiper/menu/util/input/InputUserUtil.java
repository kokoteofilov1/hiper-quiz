package hiper.menu.util.input;

import hiper.models.Gender;
import hiper.models.Role;
import hiper.models.User;

import java.util.Scanner;

public final class InputUserUtil {
    private static Scanner console = new Scanner(System.in);

    private InputUserUtil(){
        throw new UnsupportedOperationException();
    };

    public static User getUser() {
        User user = new User();

        System.out.print("username: ");
        String username = console.nextLine().trim();
        //TODO validate username
        user.setUsername(username);

        System.out.print("email: ");
        String email = console.nextLine().trim();
        //TODO validate email
        user.setEmail(email);

        System.out.print("password: ");
        String password = console.nextLine().trim();
        //TODO validate password
        user.setPassword(password);

        System.out.printf("Choose from the following: [MALE, FEMALE]%n" +
                "gender: ");
        String gender = console.nextLine().trim().toUpperCase();
        //TODO validate gender
        user.setGender(Gender.valueOf(gender));

        System.out.printf("Choose from the following: [PLAYER, ADMINISTRATOR]%n" +
                "role: ");
        String role = console.nextLine().trim().toUpperCase();
        //TODO validate role
        user.setRole(Role.valueOf(role));

        return user;
    }

    public static User getUserWithId() {
        User user = getUser();

        user.setId(InputIdUtil.getId());

        return user;
    }
}
