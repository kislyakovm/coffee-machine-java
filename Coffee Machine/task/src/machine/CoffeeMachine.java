package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        cupsCalculating();
    }

    public static void cupsCalculating() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need: ");
        int numOfCups = scanner.nextInt();

        System.out.printf("For %d cups of coffee you will need:\n", numOfCups);
        System.out.printf("%d ml of water\n", numOfCups * 200);
        System.out.printf("%d ml of milk\n", numOfCups * 50);
        System.out.printf("%d g of coffee beans\n", numOfCups * 15);
    }

    public void printActions() {
        String standardMessages = """
                Starting to make a coffee
                Grinding coffee beans
                Boiling water
                Mixing boiled water with crushed coffee beans
                Pouring coffee into the cup
                Pouring some milk into the cup
                Coffee is ready!""";

        System.out.println(standardMessages);
    }
}
