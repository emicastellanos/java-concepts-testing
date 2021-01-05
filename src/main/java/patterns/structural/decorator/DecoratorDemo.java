package patterns.structural.decorator;

public class DecoratorDemo {

    public static void main (String ... args){
        Beverage coffee = new RegularCoffeeBeverage();
        System.out.println("adding cinnamon");
        coffee = new CinnamonDecorator(coffee);
        System.out.println("adding cream");
        coffee = new CreamDecorator(coffee);

        System.out.println(":: summary ::");
        String summary = String.format("order: %s %ncost: %s", coffee.getDescription(), coffee.getCost());
        System.out.println(summary);
    }
}
