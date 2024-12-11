import Common.DoTask;
import Common.Input;

import java.io.IOException;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws IOException {
        DoTask task = null;

        String numTask;

        menu();

        try {
            while (true) {
                numTask = Input.getInput().nextLine();

                switch (numTask) {
                    case "1":
                        task = new Task1.FindMinValue();
                        break;
                    case "2":
                        task = new Task2.DescriptionOfNumber();
                        break;
                    case "3":
                        task = new Task3.MultiplicationTable();
                        break;
                    case "4":
                        task = new Task4.NumberProgression();
                        break;
                    case "5":
                        task = new Task5.LeapYear();
                        break;
                    case "0":
                        System.exit(0);
                        break;
                    default:
                        if (numTask.isEmpty()) {
                            continue;
                        }
                        System.out.println("Такого задания нет");
                        break;
                }

                try {
                    if (task != null) {
                        task.runTask();
                        System.out.println(task);
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Неверный ввод! Введенное значение не является числом!");
                } catch (IllegalArgumentException | IOException ex){
                    System.out.println(ex.getMessage());
                } finally {
                    menu();
                    task = null;
                }
            }
        } finally {
            Input.close();
        }
    }

    private static void menu() throws IOException {
        System.out.println("\n1 - Задание 1 (Поиск минимального из двух значений)");
        System.out.println("2 - Задание 2 (Описание числа)");
        System.out.println("3 - Задание 3 (Таблица умножения)");
        System.out.println("4 - Задание 4 (Арифметическая, Геометрическая прогрессия для N чисел)");
        System.out.println("5 - Задание 5 (Определение високосный год или нет)");
        System.out.println("0 - Выход\n");

        System.out.print("Введите номер задания: ");
    }
}
