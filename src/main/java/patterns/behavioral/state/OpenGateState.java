package patterns.behavioral.state;

public class OpenGateState implements GateState  {
    private GateContext gateContext;

    public OpenGateState(GateContext gateContext) {
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
