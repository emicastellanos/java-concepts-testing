package patterns.behavioral.state;

public class CloseGateState implements GateState {

    private GateContext gateContext;

    public CloseGateState (GateContext gateContext){
        this.gateContext = gateContext;
    }

    @Override
    public GateState pay() {
        System.out.println("pay from state closed");
        return new ProcessingGateState(gateContext);
    }

    @Override
    public GateState enter() {
        System.out.println("could not enter from state closed");
        return this;
    }
}
