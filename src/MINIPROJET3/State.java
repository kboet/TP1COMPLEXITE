package MINIPROJET3;

import java.util.HashMap;
import java.util.Map;

public class State {


    boolean isFinal;
    boolean isInitial;
    Map<Character,Transitions> transitions = new HashMap<>();

    public State( Map transitions) {
        this.transitions = transitions;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public void setInitial(boolean initial) {
        isInitial = initial;
    }


    public int getNextState(char c) {
        return transitions.get(c).state;
    }

    public int getMove(char c){
        return  transitions.get(c).getMove();

    }

    public char getExpectedChar(char c){
        try{
           return transitions.get(c).getExpectedChar();
        }
        catch (NullPointerException e){
            System.out.println("MOT NON ACCEPTE");
        }
        return transitions.get(c).getExpectedChar();
    }


}
