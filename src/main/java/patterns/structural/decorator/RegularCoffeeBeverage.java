package patterns.structural.decorator;

public class RegularCoffeeBeverage extends Beverage {

    private final double cost;

    public RegularCoffeeBeverage(){
        this.cost = 1.00;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getDescription() {
        return "Regular Coffee";
    }
}
