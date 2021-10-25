package ru.dataart.academy.java;

public class ReverseInteger {
    /**
     * @param inputNumber - any integer value
     * @return - inputNumber in reversed order
     * Example: 1234 -> 4321
     * -23 -> -32
     * 120 -> 21
     * -2,147,483,648 -> exception and error message
     * If result (number in reversed order) is out of int range [-2,147,483,648,  2,147,483,647] throw custom
     * unchecked exception. In main method (Main class) if exception happened output message with problem to user.
     */

    public int reverse(int inputNumber) {
        int result = 0;
        if (Math.abs(inputNumber) < 0) {
            throw new ArithmeticException("Минимальное значение int не может быть конвертировано");
        }
        int num = (inputNumber < 0) ? -inputNumber : inputNumber;
        int sigh = (inputNumber < 0) ? -1 : 1;

        while (num > 0) {
            long tmp;
            tmp = result * 10L;
            if (tmp > Integer.MAX_VALUE) {
                throw new ArithmeticException("Выход за границы int");
            }

            result *= 10;
            tmp = result + num % 10L;
            if (tmp > Integer.MAX_VALUE) {
                throw new ArithmeticException("Выход за границы int");
            }
            result += num % 10;
            num /= 10;
        }

        return result * sigh;
    }
}
