package MINIPROJET2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ZoneVide {


    public static boolean isVide(int[][] G, ArrayList<Integer> S){
        for(int i = 0; i < S.size(); i++){
            for(int y = 0; y < S.size(); y++){
                int a = S.get(i);
                int b = S.get(y);
                if(G[a][b] == 1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void MaxVide(int[][] G){
        ArrayList<ArrayList<ArrayList>> zonesVide = new ArrayList<>();
        ArrayList s = new ArrayList();
        for (int i = 0; i < G.length; i++){
            s.add(i);
        }
        zonesVide.add(s);
        zonesVide = ListVide(G, zonesVide);
        ArrayList max = Collections.max(zonesVide, new Comparator<>() {
            @Override
            public int compare(ArrayList o1, ArrayList o2) {
                return o1.size() - o2.size();
            }
        });

        System.out.println(max);


    }

    public static ArrayList<ArrayList<ArrayList>> ListVide(int[][] G, ArrayList<ArrayList<ArrayList>> z) {
        ArrayList<ArrayList<ArrayList>> zonesVide = new ArrayList<>();
        Boolean allVide = true;
        for (ArrayList zone : z) {
            Boolean isVide = true;
            for (int i = 0; i < zone.size(); i++) {
                ArrayList s1 = new ArrayList<>();
                ArrayList s2 = new ArrayList<>();
                for (int y = i; y < zone.size(); y++) {
                    int a = (int) zone.get(i);
                    int b = (int) zone.get(y);
                    if (G[a][b] == 1) {
                        isVide = false;
                        s1.clear();
                        s2.clear();
                        s1.addAll(zone);
                        s1.remove(i);
                        s2.addAll(zone);
                        s2.remove(y);
                        if (!zonesVide.contains(s1)) zonesVide.add(s1);
                        if (!zonesVide.contains(s2)) zonesVide.add(s2);
                    }
                }
            }
            if (isVide){
                zonesVide.add(zone);
            }
        }
        for (ArrayList zone: zonesVide){
            if(!isVide(G,zone)) allVide = false;
        }

        if (!allVide) zonesVide = ListVide(G, zonesVide);
        return zonesVide;
    }




    public static void main(String[] args) {
        int [][] G = {
                {0,1,1,1,0,1,1},{1,0,1,0,0,0,0},
                {1,1,0,1,0,1,1},{1,0,1,0,0,0,0},
                {0,0,0,0,0,1,0},{1,0,1,0,1,0,0},
                {1,0,1,0,0,0,0}
        };
        MaxVide(G);
    }
}
