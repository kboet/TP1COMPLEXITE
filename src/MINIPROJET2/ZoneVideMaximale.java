package MINIPROJET2;

import java.util.ArrayList;

public class ZoneVideMaximale {



    public static boolean isVide(int[][] G, ArrayList<Integer> S){
        for(int x = 0; x < S.size(); x++){
            for(int y = 0; y < S.size(); y++){
                int a = S.get(x);
                int b = S.get(y);
                if(G[a][b] == 1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void readMatrice(int[][] matrix3){
        ArrayList<ArrayList> initEnsVide= new ArrayList<>();
        for (int raw= 0; raw < matrix3.length; raw++){
            ArrayList<Integer> tmp= new ArrayList<>();
            for (int col= 0; col < matrix3.length; col++){
                if(matrix3[raw][col] == 0){
                    tmp.add(col);
                }
            }
            initEnsVide.add(tmp);
        }
        ArrayList<ArrayList> ensVide= new ArrayList<>();
        for (int i = 0; i < initEnsVide.size(); i++) {
            if (isVide(matrix3, initEnsVide.get(i)) && !initEnsVide.contains(i)){
                //System.out.println(ensVide.get(i) + " TRUE");
                ensVide.add(initEnsVide.get(i));
            }//else System.out.println(ensVide.get(i) + " FALSE");
        }
        for (int i = 0; i < ensVide.size(); i++) {
            for (int j = 0; j < ensVide.size(); j++) {
                if (i!=j){
                    if (ensVide.get(i).equals(ensVide.get(j))){
                        ensVide.remove(j);
                    }
                }
            }
        }

        System.out.println(ensVide);
    }


    public static void main(String[] args) {
        int[][] matrices= {{0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 1, 0}};
        int[][] matrices2= {{0, 1, 1, 0, 0, 1, 1},
                {1, 0, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        int[][] matrices3= {{0, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 0}};


        readMatrice(matrices3);
    }


}
