import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.println("Выберите алгоритм:");
            System.out.println("1. Если введенное число больше 7, то вывести 'Привет'.");
            System.out.println("2. Поиск имени Вячеслав.");
            System.out.println("3. Числа кратные 3 в массиве.");
            System.out.println("4. Выход");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Ошибка! Введите целое число от 1 до 4");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("Введите число:");
                        try {
                            int num = scanner.nextInt();
                            scanner.nextLine();
                            if (num > 7) {
                                System.out.println("Привет");
                            } else {
                                System.out.println("Число меньше или равно 7");
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Ошибка! Введите целое число");
                            scanner.nextLine();
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.println("Введите имя:");
                        String name = scanner.nextLine().trim();
                        boolean isNameValid = true;
                        for (int i = 0; i < name.length(); i++) {
                            if (!Character.isLetter(name.charAt(i))) {
                                isNameValid = false;
                                break;
                            }
                        }
                        if (isNameValid) {
                            if (name.equals("Вячеслав")) {
                                System.out.println("Привет, Вячеслав");
                            } else {
                                System.out.println("Нет такого имени");
                            }
                            break;
                        } else {
                            System.out.println("Ошибка! Имя должно содержать только буквы");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Введите целые числа через пробел:");
                    String[] input = scanner.nextLine().split("\\s+");
                    int[] array = new int[input.length];
                    boolean hasErrors = false;
                    for (int i = 0; i < input.length; i++) {
                        try {
                            array[i] = Integer.parseInt(input[i]);
                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка! Введите целые числа через пробел");
                            hasErrors = true;
                            break;
                        }
                    }
                    if (!hasErrors) {
                        System.out.println("Элементы массива, кратные 3:");
                        boolean hasMultiplesOfThree = false;
                        for (int num : array) {
                            if (num % 3 == 0) {
                                System.out.print(num + " ");
                                hasMultiplesOfThree = true;
                            }
                        }
                        if (!hasMultiplesOfThree) {
                            System.out.println("В массиве нет элементов, кратных 3");
                        } else {
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Ошибка! Введите целое число от 1 до 4");
                    break;
            }
        }

        scanner.close();
    }
}
