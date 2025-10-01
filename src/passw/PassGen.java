package passw;

import java.util.Random;
import java.util.Scanner;

public class PassGen {
    public static void main(String args[]) {
        String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String possibleNums = "0123456789";
        String possibleSpec = "!@#$%^&*()._-";

        Random rand = new Random();
        int choice = rand.nextInt(3);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите число символов пароля: ");
            int passw_lenght = Integer.parseInt(scanner.nextLine());
            StringBuilder password = new StringBuilder();

            for (int i = passw_lenght; i > 0; i--) {
                switch (choice) {
                    case 0:
                        password.append(possibleChars.charAt(rand.nextInt(possibleChars.length())));
                        break;
                    case 1:
                        password.append(possibleNums.charAt(rand.nextInt(possibleNums.length())));
                        break;
                    case 2:
                        password.append(possibleSpec.charAt(rand.nextInt(possibleSpec.length())));
                        break;
                }
                choice = rand.nextInt(3);
            }
            System.out.println("Сгенерированный пароль: " + password + "\n");
            System.out.println("сгенерировать еще один пароль? (да/нет) \n");
            String answer = scanner.nextLine();
            if (!answer.equals("да") && !answer.equals("yes")) {
                break;
            }
        }
        scanner.close();
    }
}
