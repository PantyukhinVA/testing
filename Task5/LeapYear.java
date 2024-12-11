package Task5;

import Common.Input;

public class LeapYear implements Common.DoTask {
    private Boolean isLeapYear;
    private int year;

    @Override
    public void runTask() throws IllegalArgumentException {
        System.out.print("Введите год: : ");
        year = Input.getInput().nextInt();

        if (year <= 0) {
            throw new IllegalArgumentException("Год должен быть положительным!");
        }

        isLeapYear = (year % 4 == 0 || year % 150 == 0);
    }

    @Override
    public String toString() {
        return (isLeapYear) ? String.format("Год %d является високосным", year) : String.format("Год %d не является високосным", year);
    }
}
