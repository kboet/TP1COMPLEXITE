package MINIPROJET3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class TuringMachine {

    String mot;
    static int  pointer = 0;
    static int actualState = 0;
    static ArrayList<Character> alphabet;
    static ArrayList<State> lStates = new ArrayList<>();
    static String file = "src/MINIPROJET3/turing.txt";

    public TuringMachine(String filename) {
        try
        {
            FileInputStream file = new FileInputStream(filename);
            Scanner scanner = new Scanner(file);
            Map<Character,Transitions> state = new HashMap<>();
            if (scanner.hasNextLine()) System.out.println(scanner.nextLine());
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] l = line.split(" ");
                switch (l[0]){
                    case ("A"):
                        alphabet = new ArrayList<>(l.length-1);
                        for (int i = 0; i < l.length-1; i++){
                            alphabet.add(i,l[i+1].charAt(0));
                        }
                    case ("S"):
                        state = new HashMap<>();
                        break;
                    case ("T"):
                        char expectedChar = l[2].charAt(0);
                        char movement = l[3].charAt(0);
                        int nextState = Integer.parseInt(l[4]);
                        state.put(l[1].charAt(0),new Transitions(expectedChar,movement,nextState));
                        break;
                    case("NEXTSTATE"):
                        lStates.add(new State(state));
                        break;
                }
            }
            lStates.get(0).setInitial(true);
            lStates.get(lStates.size()-1).setFinal(true);
            scanner.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    static public boolean wordIsAccepted(String mot){
        char[] character = mot.toCharArray();
        for (char c: character){
            if (!alphabet.contains(c)) return false;
        }
        return true;
    }

    static public void run(String mot){
        System.out.println("Mot en entrée: " + mot);
        if (wordIsAccepted(mot)) {
            mot = mot + "###";
            int counter = 0;
            char[] bande = mot.toCharArray();

            while (!lStates.get(actualState).isFinal) {
                if (pointer == -1) {
                    bande = ("#" + String.valueOf(bande)).toCharArray();
                    pointer = 0;
                }
                System.out.print(counter + " : ");
                counter++;
                String bandeL = String.valueOf(bande).substring(0, pointer);
                String bandeR = String.valueOf(bande).substring(pointer, bande.length);
                System.out.println(bandeL + actualState + bandeR);
                char c = bande[pointer];
                State s = lStates.get(actualState);
                bande[pointer] = s.getExpectedChar(c);
                pointer += s.getMove(c);
                actualState = s.getNextState(c);

            }
            System.out.print("END ");
            System.out.print(counter + " : ");
            String bandeL = String.valueOf(bande).substring(0, pointer);
            String bandeR = String.valueOf(bande).substring(pointer, bande.length);
            System.out.println(bandeL + actualState + bandeR);
        }
        else System.out.println("WORD NOT ACCEPTED");

    }

    public static void main(String[] args) {
        new TuringMachine(file);

        run("aaabbb");
    }

}