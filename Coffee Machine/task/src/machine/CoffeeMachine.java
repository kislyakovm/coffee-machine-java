package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int disposableCups = 9;
    private int money = 550;

    public int getWater() {
        return water;
    }

    public void setWater(int water, String action) {
        if ("add".equals(action)) this.water += water;
        else this.water -= water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk, String action) {
        if ("add".equals(action)) this.milk += milk;
        else this.milk -= milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans, String action) {
        if ("add".equals(action)) this.coffeeBeans += coffeeBeans;
        else this.coffeeBeans -= coffeeBeans;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public void setDisposableCups(int disposableCups, String action) {
        if ("add".equals(action)) this.disposableCups += disposableCups;
        else this.disposableCups -= 1;
    }

    public int getMoney() {
        return money;
    }

    public void takeMoney(int money, String action) {
        if ("add".equals(action)) this.money += money;
        else this.money = 0;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        printInfo(coffeeMachine);

        System.out.println("Write action (buy, fill, take):");
        String action = scanner.nextLine();

        switch (action) {
            case "buy" -> buy(coffeeMachine);
            case "fill" -> fill(coffeeMachine);
            case "take" -> {
                System.out.printf("I gave you $%d\n\n", coffeeMachine.getMoney());
                coffeeMachine.takeMoney(0, "take");
            }
        }

        printInfo(coffeeMachine);
    }

    public static void buy(CoffeeMachine coffeeMachine) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");

        int typeOfCoffee = scanner.nextInt();
        System.out.println();

        switch (typeOfCoffee) {
            case 1 -> {
                Espresso espresso = new Espresso();
                coffeeMachine.setWater(espresso.getWATER(), "buy");
                coffeeMachine.setMilk(espresso.getMILK(), "buy");
                coffeeMachine.setCoffeeBeans(espresso.getCOFFEE_BEANS(), "buy");
                coffeeMachine.setDisposableCups(0, "buy");
                coffeeMachine.takeMoney(espresso.getCOST(), "add");
            }
            case 2 -> {
                Latte latte = new Latte();
                coffeeMachine.setWater(latte.getWATER(), "buy");
                coffeeMachine.setMilk(latte.getMILK(), "buy");
                coffeeMachine.setCoffeeBeans(latte.getCOFFEE_BEANS(), "buy");
                coffeeMachine.setDisposableCups(0, "buy");
                coffeeMachine.takeMoney(latte.getCOST(), "add");
            }
            case 3 -> {
                Cappuccino cappuccino = new Cappuccino();
                coffeeMachine.setWater(cappuccino.getWATER(), "buy");
                coffeeMachine.setMilk(cappuccino.getMILK(), "buy");
                coffeeMachine.setCoffeeBeans(cappuccino.getCOFFEE_BEANS(), "buy");
                coffeeMachine.setDisposableCups(0, "buy");
                coffeeMachine.takeMoney(cappuccino.getCOST(), "add");
            }
        }
    }

    public static void fill(CoffeeMachine coffeeMachine) {

        int water = inputIngredient("water", "ml");
        coffeeMachine.setWater(water, "add");

        int milk = inputIngredient("milk", "ml");
        coffeeMachine.setMilk(milk, "add");

        int coffeeBeans = inputIngredient("coffee beans", "grams");
        coffeeMachine.setCoffeeBeans(coffeeBeans, "add");

        int disposableCups = inputDisposableCups("disposable cups");
        coffeeMachine.setDisposableCups(disposableCups, "add");

        System.out.println();
    }

    public static void printInfo(CoffeeMachine coffeeMachine) {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", coffeeMachine.getWater());
        System.out.printf("%d ml of milk\n", coffeeMachine.getMilk());
        System.out.printf("%d g of coffee beans\n", coffeeMachine.getCoffeeBeans());
        System.out.printf("%d disposable cups\n", coffeeMachine.getDisposableCups());
        System.out.printf("$%d of money\n", coffeeMachine.getMoney());
        System.out.println();
    }

    public static int inputIngredient(String ingredient, String metricUnit) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Write how many %s of %s you want to add:\n", metricUnit, ingredient);
        return scanner.nextInt();
    }

    public static int inputDisposableCups(String ingredient) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Write how many %s you want to add:\n", ingredient);
        return scanner.nextInt();
    }
}
