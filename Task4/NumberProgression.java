package Task4;

import Common.Input;

import java.io.IOException;
import java.util.InputMismatchException;

enum TypeProgression {
    ARITHMETIC,
    GEOMETRIC;

    public static TypeProgression fromValue(String x) throws IOException {
        return switch (x) {
            case "1" -> ARITHMETIC;
            case "2" -> GEOMETRIC;
            default -> throw new IOException("Неизвестный тип прогрессии");
        };
    }
}

public class NumberProgression implements Common.DoTask {
    private final StringBuilder resultOfProgression = new StringBuilder();

    @Override
    public void runTask() throws InputMismatchException, IOException {
        System.out.print("Выберите тип прогрессии (1 - арифметическая, 2 - геометрическая): ");

        String choice = Input.getInput().nextLine();
        TypeProgression typeProgression = TypeProgression.fromValue(choice);

        System.out.print("Введите количество чисел (N): ");
        int count = Input.getInput().nextInt();

        System.out.print("Введите первое известное число прогрессии: ");
        int firstElement = Input.getInput().nextInt();

        System.out.print("Введите шаг или знаменатель прогрессии: ");
        int step = Input.getInput().nextInt();

        resultOfProgression.append((typeProgression == TypeProgression.ARITHMETIC) ? "Арифметическая" : "Геометрическая")
                .append(" прогрессия для ")
                .append(count)
                .append(" чисел ")
                .append(" с шагом: ")
                .append(step)
                .append(" с первым известным элементом: ")
                .append(firstElement)
                .append(" = ");


        getResultOfProgression(firstElement, step, count, typeProgression);

    }

    private int getResultOfProgression(int firstElement, int step, int count, TypeProgression typeProgression) {
        if (count > 1) {
            if (typeProgression == TypeProgression.GEOMETRIC) {
                firstElement = step * getResultOfProgression(firstElement, step, count - 1, typeProgression);
            } else if (typeProgression == TypeProgression.ARITHMETIC) {
                firstElement = step + getResultOfProgression(firstElement, step, count - 1, typeProgression);
            }

            resultOfProgression.append(firstElement).append(" ");
        } else {
            return firstElement;
        }

        return firstElement;
    }

    @Override
    public String toString() {
        return resultOfProgression.toString();
    }
}
