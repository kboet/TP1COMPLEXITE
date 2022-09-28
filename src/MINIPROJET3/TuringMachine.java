import java.util.ArrayList;

public class TuringMachine {

    String mot;
    int  pointer;
    State actualState;
    ArrayList<State> lStates = new ArrayList<>();

    public TuringMachine(String mot, int pointer, State actualState, ArrayList<State> lStates) {
        this.mot = mot;
        this.pointer = pointer;
        this.actualState = actualState;
        this.lStates = lStates;
    }
    
}
