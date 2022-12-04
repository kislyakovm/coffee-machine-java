package machine;

class Espresso {

    protected int getWATER() {
        return 250;
    }

    protected int getMILK() {
        return 0;
    }

    protected int getCOFFEE_BEANS() {
        return 16;
    }

    protected int getCOST() {
        return 4;
    }
}

class Latte {

    protected int getWATER() {
        return 350;
    }

    protected int getMILK() {
        return 75;
    }

    protected int getCOFFEE_BEANS() {
        return 20;
    }

    protected int getCOST() {
        return 7;
    }
}

class Cappuccino {

    protected int getWATER() {
        return 200;
    }

    protected int getMILK() {
        return 100;
    }

    protected int getCOFFEE_BEANS() {
        return 12;
    }

    protected int getCOST() {
        return 6;
    }
}
