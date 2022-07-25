import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y, int d) { // Имена переменных можно подсмотреть в соседнем методе 
        double pay = a * Math.pow((1 + y / 12), 12 * d); // переменная y - всегда равна 0.06 я убрал ее из всех переменных методов и просто вписал ее числом в формулу
        return calculateAndRound(pay, 2); // "return Math.round(значение)"
    }

    double calculateSimplePercent(double doubleAmount, double doubleYearRate, int depositPeriod) { // в имени переменных не должно быть double
        return calculateAndRound(doubleAmount + doubleAmount * doubleYearRate * depositPeriod, 2);
    }

    double calculateAndRound(double value, int places) { // этот метод по сути ничего не делает. в предыдущих методах можно просто писать "return Math.round(значение)"
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe; // Вглядись, тут ты уммножаешь на 100 и сразу делишь на 100. в этом нет смысла)
    }

    void mainMenu() { // имена методов должны быть глаголами. имена класов существительными
        int period;
        int action;
        Scanner scanner = new Scanner(System.in); // После объявления переменных необходимо добавить пустую строку
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt(); // пустая строка +1 Эту переменную надо объявить в начале метода
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt(); // пустая строка +1
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt(); // пустая строка +1
        double out = 0; // Эту переменную надо объявить в начале метода
        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().mainMenu();
    }

}
