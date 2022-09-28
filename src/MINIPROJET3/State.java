import java.util.HashMap;
import java.util.Map;

public class State {
    boolean isFinal;
    boolean isInitial;
    Map<Character,Transitions> transitions = new HashMap<>();

    public State(boolean isInitial, boolean isFinal) {
        this.isInitial = isInitial;
        this.isFinal = isFinal;
    }


    public boolean isFinal() {
        return isFinal;
    }

    public boolean isInitial() {
        return isInitial;
    }


    public State getNextState(char c) {
        return transitions.get(c).state;
    }

    public int getMove(char c){
        return  transitions.get(c).getMove();

    }

    public int getExpectedChar(char c){
        return transitions.get(c).getExpectedChar();
    }


}
