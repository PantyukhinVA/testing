package Task3;

import Common.Input;

import java.io.IOException;
import java.util.InputMismatchException;

public class MultiplicationTable implements Common.DoTask {
    private StringBuilder multiplicationTable;
    private int number;

    @Override
    public void runTask() throws InputMismatchException, IOException {
        System.out.print("Введите число до которго необходимо вывести таблицу умножения: ");
        number = Input.getInput().nextInt();

        if (number < 0) {
            throw new IOException(String.format("Неверное значение %d! Введите положительное число!", number));
        }

        multiplicationTable = new StringBuilder();

        for (int i = 1; i <= number; i++) {
            multiplicationTable.append(System.lineSeparator());
            for (int j = 1; j <= number; j++) {
                multiplicationTable.append(i * j).append("\t");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Таблиц умножения до числа %d: %s", number, multiplicationTable);
    }
}
