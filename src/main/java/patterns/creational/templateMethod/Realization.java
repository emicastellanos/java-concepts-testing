package patterns.creational.templateMethod;

class Realization extends Specialization {
    // 4. Derived classes can override placeholder methods
    @Override
    protected void stepTwo() {
        System.out.println("Realization.stepTwo");
    }

    @Override
    protected void step3_2() {
        System.out.println( "Realization.step3_2");
    }

    // 5. Derived classes can override implemented methods
    // 6. Derived classes can override and "call back to" base class methods
    @Override
    protected void stepFor() {
        System.out.println("Realization.stepFor");
        super.stepFor();
    }
}