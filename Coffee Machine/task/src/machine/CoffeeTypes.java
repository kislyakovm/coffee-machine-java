package machine;

class Coffee {

    int water;
    int milk;
    int coffeeBeans;
    int cost;

    public Coffee(int water, int milk, int coffeeBeans, int cost) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cost = cost;
    }

    protected int getWater() {
        return water;
    }

    protected int getMilk() {
        return milk;
    }

    protected int getCoffeeBeans() {
        return coffeeBeans;
    }

    protected int getCost() {
        return cost;
    }
}
