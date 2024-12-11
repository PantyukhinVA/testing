package Task2;

import Common.Input;

import java.util.InputMismatchException;

public class DescriptionOfNumber implements Common.DoTask {
    private String description;
    private double number;

    @Override
    public void runTask() throws InputMismatchException {
        System.out.print("Введите число: ");
        number = Input.getInput().nextDouble();

        if (number < 0) {
            description = "отрицательное";
        } else if (number == 0) {
            description = "нулевое";
        } else {
            description = "положительное";
        }

        if (number % 2 == 0) {
            description += ", четное";
        } else {
            description += ", нечетное";
        }
    }

    @Override
    public String toString() {
        return String.format("Номер %.2f - %s", number, description);
    }
}
