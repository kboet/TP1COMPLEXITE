package MINIPROJET3;

public class Transitions {
    char expectedChar, move;
    int state;

    public Transitions(char expectedChar, char move, int state) {
        this.expectedChar = expectedChar;
        this.move = move;
        this.state = state;
    }

    public char getExpectedChar() {
        return expectedChar;
    }

    public int getMove() {
        if(move == 'R') return 1;
        return -1;
    }

    public int getState() {
        return state;
    }
}
