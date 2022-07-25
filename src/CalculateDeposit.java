import java.util.Scanner;
//Отлично решение с удалением ненужного метода. 
//Код хорошо читается, замечяний нет:)
public class CalculateDeposit {
    double calculateComplexPercent(double amount, int depositPeriodInYear) {
        return Math.round(amount * Math.pow((1 + 0.06 / 12), 12 * depositPeriodInYear));
    }

    double calculateSimplePercent(double amount, int depositPeriodInYear) {
        return Math.round(amount + amount * 0.06 * depositPeriodInYear);
    }

    void runPercentManager() {
        int period;
        int action;
        int amount;
        double totalSum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1)
            totalSum = calculateSimplePercent(amount, period);
        else if (action == 2)
            totalSum = calculateComplexPercent(amount, period);
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + totalSum);
    }

    public static void main(String[] args) {
        new CalculateDeposit().runPercentManager();
    }
}
