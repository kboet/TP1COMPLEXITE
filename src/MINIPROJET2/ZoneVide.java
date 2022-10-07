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

    //PREND EN ENTREE UN GRPAHE ET RENVOI LA ZONE VIDE LA PLUS GRANDE
    public static void MaximumVide(int[][] G){
        ArrayList<ArrayList> zonesVide = new ArrayList<>();
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

    //ON PREND EN ENTREE LE GRAPHE G ET UNE LISTE D'ENSEMBLE DE SOMMET
    // SI IL Y'A UN ARC COMMUN A DEUX SOMMET ON CREE DEUX ENSMBLE {1,2,3} & arc(1,2) -> {1,3} & {2,3}
    // APPEL RECURSIF QUI PREND EN ENTREE UNE LISTE D'ENSEMBLE AVEC LES NOUVEAUX ENSEMBLES & LES ENSEMBLES VIDE PRECEDENTS
    // LE PROGRAMME S'ARRETE QUAND TOUT LES ENSMBLES SONT VIDE
    public static ArrayList<ArrayList> ListVide(int[][] G, ArrayList<ArrayList> z) {
        ArrayList<ArrayList> zonesVide = new ArrayList<>();

        Boolean allVide = true;
        for (ArrayList zone : z) {
            Boolean isVide = true;
            for (int i = 0; i < zone.size(); i++) {
                for (int y = i; y < zone.size(); y++) {
                    ArrayList s1 = new ArrayList<>();
                    ArrayList s2 = new ArrayList<>();
                    int a = (int) zone.get(i);
                    int b = (int) zone.get(y);
                    if (G[a][b] == 1) {
                        isVide = false;
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


    static public ArrayList zoneMaximale(int[][] G){
        ArrayList  zoneMaximale = new ArrayList();
        for (int i = 0; i<G.length;i++){
            ArrayList temp = new ArrayList<>();
            temp.addAll(zoneMaximale);
            temp.add(i);
            if (isVide(G,temp)) zoneMaximale.add(i);
        }
        System.out.println(zoneMaximale);
        return zoneMaximale;
    }

    static public ArrayList zoneMaximumInc(int[][] G){
        ArrayList<ArrayList> zones = new ArrayList();

        for (int i = 0; i<G.length;i++){
            ArrayList  zoneMaximale = new ArrayList();
            for (int y = i; y<G.length;y++){
            ArrayList temp = new ArrayList<>();
            temp.addAll(zoneMaximale);
            temp.add(y);
            if (isVide(G,temp)) zoneMaximale.add(y);
            }
            zones.add(zoneMaximale);
        }
        ArrayList max = Collections.max(zones, new Comparator<>() {
            @Override
            public int compare(ArrayList o1, ArrayList o2) {
                return o1.size() - o2.size();
            }
        });
        return max;
    }

    static public int[][] generateGraph(int s){
        int[][] G = new int[s][s];
        G[0][0] = 1;
        for(int i = 1; i<s; i++){
            G[0][i] = 1;
        }
        for(int i = 1; i<s; i++){
            G[i][0] = 1;
            for(int y = 1; y<s; y++){
                G[i][y] = 0;
            }
        }

        return G;

    }


    public static void main(String[] args) {


        int[][] G= {{0, 1, 1, 0, 0, 1, 1},
                {1, 0, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};

        System.out.println(zoneMaximumInc(G));

    }
}
