package Task1;

import Common.Input;

import java.util.InputMismatchException;

public class FindMinValue implements Common.DoTask {

    private double minValue;

    @Override
    public void runTask() throws InputMismatchException {

        System.out.print("Введите первое число: ");
        double num1 = Input.getInput().nextDouble();

        System.out.print("Введите второе число: ");
        double num2 = Input.getInput().nextDouble();

        minValue = Math.min(num1, num2);
    }

    @Override
    public String toString() {
        return String.format("Минимальное число: %.2f", minValue);
    }
}
