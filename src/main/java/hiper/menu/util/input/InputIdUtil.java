package hiper.menu.util.input;

import java.util.Scanner;

public abstract class InputIdUtil {
    private static Scanner console = new Scanner(System.in);

    private InputIdUtil() {
        throw new UnsupportedOperationException();
    }

    public static long getId() {
        System.out.printf("Enter ID for entity you want to modify:%n" +
                "ID: ");
        long id = Long.parseLong(console.nextLine().trim());

        return id;
    }
}
