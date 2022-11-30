package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        int water = inputIngredientQuantity("water", "ml");
        int milk = inputIngredientQuantity("milk", "ml");
        int coffeeBeans = inputIngredientQuantity("coffee beans", "grams");
        int cups = inputCupsQuantity();

        cupsCalculating(water, milk, coffeeBeans, cups);
    }

    public static int inputIngredientQuantity(String ingredient, String metricUnit) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Write how many %s of %s the coffee machine has:\n", metricUnit, ingredient);
        return scanner.nextInt();
    }

    public static int inputCupsQuantity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        return scanner.nextInt();
    }

    public static void cupsCalculating(int water, int milk, int coffeeBeans, int cups) {

        StandardCoffee standardCoffee = new StandardCoffee();

        int waterForCups = water / standardCoffee.getWATER();
        int milkForCups = milk / standardCoffee.getMILK();
        int coffeeBeansForCups = coffeeBeans / standardCoffee.getCOFFEE_BEANS();

        int minCupsQuantity = findMinCupsQuantity(waterForCups, milkForCups, coffeeBeansForCups);
        checkHowMuchCups(cups, minCupsQuantity);
    }

    public static void checkHowMuchCups(int cups, int minCupsQuantity) {
        if (cups == minCupsQuantity) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cups > minCupsQuantity) {
            System.out.printf("No, I can make only %d cup(s) of coffee", minCupsQuantity);
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)"
                    , minCupsQuantity - cups);
        }
    }

    public static int findMinCupsQuantity(int waterForCups, int milkForCups, int coffeeBeansForCups) {
        int min;

        if (waterForCups < milkForCups) {
            min = Math.min(waterForCups, coffeeBeansForCups);
        } else {
            min = Math.min(milkForCups, coffeeBeansForCups);
        }
        return min;
    }
}
