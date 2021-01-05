package patterns.structural.decorator;

public class CinnamonDecorator extends Beverage {
    private Beverage decorated;

    public CinnamonDecorator(Beverage decorated){
        this.decorated = decorated;
    }

    @Override
    public double getCost() {
        return decorated.getCost() + 0.25;
    }

    @Override
    public String getDescription() {
        return decorated.getDescription() + " - Cinnamon added";
    }
}
