import password.PasswordChecker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordChecker checker = new PasswordChecker();

        try {
            System.out.print("Введите минимальную длину пароля: ");
            int minLength = Integer.parseInt(scanner.nextLine());
            checker.setMinLength(minLength);

            System.out.print("Введите максимальное число повторений подряд: ");
            int maxRepeats = Integer.parseInt(scanner.nextLine());
            checker.setMaxRepeat(maxRepeats);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return;
        }
        System.out.println("Введите пароль или end: ");
        while (true) {
            System.out.print("Пароль: ");
            String password = scanner.nextLine();
            if (password.equals("end")) {
                break;
            }
            try {
                boolean isValid = checker.verify(password);
                System.out.println(isValid ? "Подходит!" : "Не подходит!");
            } catch (IllegalStateException e) {
                System.out.println("Ошибка: " + e.getMessage());
                break;
            }
        }
        scanner.close();
        }
    }