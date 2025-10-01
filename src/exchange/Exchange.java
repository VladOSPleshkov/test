package exchange;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Exchange {
    private static Map<String, Double> cource = new HashMap<>();
    static {
        cource.put("USD", 1.0);
        cource.put("EUR", 0.9);
        cource.put("RUB", 80.0);
        cource.put("CNY", 8.0);
        cource.put("GBP", 0.8);
    }
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Доступные валюты: USD, RUB, EUR, CNY, GBP. \n");

            System.out.print("Введите валюту вашей суммы: \n");
            String val = scanner.nextLine().trim().toUpperCase();

            System.out.print("Введите сумму: \n");
            double sum = Double.parseDouble(scanner.nextLine());

            System.out.print("Введите валюту: \n");
            String need_val = scanner.nextLine().trim().toUpperCase();
            double result = change(val, sum, need_val);

            System.out.println(sum + " " + val + " = " + result + " " + need_val);

            System.out.print("Введите (да) если хотите продолжить: ");
            String answer = scanner.nextLine();
            if (!answer.equals("да") && !answer.equals("yes")) {
                break;
            }
        }
        scanner.close();
    }
    private static double change(String val, Double sum, String need_val){
        double sum_in_dollar = sum / cource.get(val);
        return sum_in_dollar * cource.get(need_val);
    }
}
