import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.println("�������� ��������:");
            System.out.println("1. ���� ��������� ����� ������ 7, �� ������� '������'.");
            System.out.println("2. ����� ����� ��������.");
            System.out.println("3. ����� ������� 3 � �������.");
            System.out.println("4. �����.");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("������! ������� ����� ����� �� 1 �� 4");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("������� �����:");
                        try {
                            int num = scanner.nextInt();
                            scanner.nextLine();
                            if (num > 7) {
                                System.out.println("������");
                            } else {
                                System.out.println("����� ������ ��� ����� 7");
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("������! ������� ����� �����");
                            scanner.nextLine();
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.println("������� ���:");
                        String name = scanner.nextLine().trim();
                        boolean isNameValid = true;
                        for (int i = 0; i < name.length(); i++) {
                            if (!Character.isLetter(name.charAt(i))) {
                                isNameValid = false;
                                break;
                            }
                        }
                        if (isNameValid) {
                            if (name.equals("��������")) {
                                System.out.println("������, ��������");
                            } else {
                                System.out.println("��� ������ �����");
                            }
                            break;
                        } else {
                            System.out.println("������! ��� ������ ��������� ������ �����");
                        }
                    }
                    break;

                case 3:
                    System.out.println("������� ����� ����� ����� ������:");
                    String[] input = scanner.nextLine().split("\\s+");
                    int[] array = new int[input.length];
                    boolean hasErrors = false;
                    for (int i = 0; i < input.length; i++) {
                        try {
                            array[i] = Integer.parseInt(input[i]);
                        } catch (NumberFormatException e) {
                            System.out.println("������! ������� ����� ����� ����� ������");
                            hasErrors = true;
                            break;
                        }
                    }
                    if (!hasErrors) {
                        System.out.println("�������� �������, ������� 3:");
                        boolean hasMultiplesOfThree = false;
                        for (int num : array) {
                            if (num % 3 == 0) {
                                System.out.print(num + " ");
                                hasMultiplesOfThree = true;
                            }
                        }
                        if (!hasMultiplesOfThree) {
                            System.out.println("� ������� ��� ���������, ������� 3");
                        } else {
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    System.out.println("����� �� ���������...");
                    break;
                default:
                    System.out.println("������! ������� ����� ����� �� 1 �� 4");
                    break;
            }
        }

        scanner.close();
    }
}
