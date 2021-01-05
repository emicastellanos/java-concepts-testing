package patterns.behavioral.state;

public class ProcessingGateState implements GateState {

    private GateContext gateContext;

    public ProcessingGateState(GateContext gateContext) {
        this.gateContext = gateContext;
    }

    @Override
    public GateState pay() {
        return null;
    }

    @Override
    public GateState enter() {
        return null;
    }
}
