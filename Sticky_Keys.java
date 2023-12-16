import java.util.*;

public class Sticky_Keys{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String correctedMessage = correctMessage(message);
        System.out.println(correctedMessage);
    }

    public static String correctMessage(String message) {
        StringBuilder corrected = new StringBuilder();
        char prevChar = '\0'; // Initialize prevChar with a value that won't match any character

        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            if (currentChar != prevChar) {
                corrected.append(currentChar);
                prevChar = currentChar;
            }
        }

        return corrected.toString();
    }
}
