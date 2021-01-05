package patterns.structural.decorator;

public class CreamDecorator extends Beverage {
    private Beverage decorated;

    public CreamDecorator(Beverage decorated){
        this.decorated = decorated;
    }

    @Override
    public double getCost() {
        return decorated.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        return decorated.getDescription() + " - Cream added";
    }
}
