public class Transitions {
    char expectedChar, move;
    State state;

    public Transitions(char expectedChar, char move, State state) {
        this.expectedChar = expectedChar;
        this.move = move;
        this.state = state;
    }

    public char getExpectedChar() {
        return expectedChar;
    }

    public char getMove() {
        return move;
    }

    public State getState() {
        return state;
    }
}
