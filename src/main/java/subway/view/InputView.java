package subway.view;

import java.util.Scanner;
import subway.constants.GeneralMessage;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readInput() {
        return scanner.nextLine().trim();
    }

    public static String readInputWithMessage(GeneralMessage message) {
        System.out.println(message);
        return scanner.nextLine().trim();
    }
}
