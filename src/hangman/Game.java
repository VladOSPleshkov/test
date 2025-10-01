package hangman;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        String[] dictionary = {"джава", "программирование", "слово", "лампочка", "город", "сервер", "земля"};

        while (true) {
            int count_lives = 5;
            System.out.print("Игра началась! \n\n");

            String keyword = dictionary[rand.nextInt(dictionary.length)];
            char[] guessed = new char[keyword.length()];
            boolean wordGuessed = false;

            for (int i = 0; i < guessed.length; i++) {
                guessed[i] = '_';
            }

            while(count_lives != 0 && !wordGuessed) {
                boolean correctGuess = false;
                System.out.print("\nСлово: ");
                for (char c : guessed) {
                    System.out.print(c + " ");
                }
                System.out.print("\n Введите букву: ");

                String input = scanner.nextLine().toLowerCase();
                char letter = input.charAt(0);

                for (int i = 0; i < keyword.length(); i++) {
                    if (keyword.charAt(i) == letter && guessed[i] == '_') {
                        guessed[i] = letter;
                        correctGuess = true;
                    }
                }
                if (!correctGuess) {
                    count_lives--;
                    System.out.println("-1 жизнь");
                }
                wordGuessed = true;
                for (char c : guessed) {
                    if (c == '_') {
                        wordGuessed = false;
                        break;
                    }
                }
            }
            if (wordGuessed) {
                System.out.println("\nПобеда! Вы отгадали слово: " + keyword);
            } else {
                System.out.println("\nВы проиграли! Загаданное слово было: " + keyword);
            }
            System.out.print("Хотите сыграть ещё раз? (да/нет): \n");
            String answer = scanner.nextLine();
            if (!answer.equals("да") && !answer.equals("yes")) {
                break;
            }
        }
        scanner.close();
    }
}
