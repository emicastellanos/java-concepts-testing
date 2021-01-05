package patterns.behavioral.state;

public class GateContext {
    private GateState gateState;

    public GateContext(){
        this.gateState = new CloseGateState(this);
    }

    public void pay(){
        gateState = gateState.pay();
    }

    public void enter(){
        gateState = gateState.enter();
    }
}
