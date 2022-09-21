package MINIPROJET2;

public class ZoneVide {


    public static boolean isVide(int[][] G, int[] S){
        for(int i = 0; i < S.length; i++){
            for(int y = 0; y < S.length; y++){
                int a = S[i];
                int b = S[y];
                if(G[a][b] == 1){
                    System.out.println(a);
                    System.out.println(b);
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int [][] G = {
                {0,1,1,0,0,1,1},{1,0,1,0,0,0,0},
                {1,1,0,1,0,1,1},{1,0,1,0,0,0,0},
                {0,0,0,0,0,1,0},{1,0,1,0,1,0,0},
                {1,0,1,0,0,0,0}
        };

        int[] S= {1,5,4};

        System.out.println(isVide(G,S));
    }
}
