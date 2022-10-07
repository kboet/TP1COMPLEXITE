package MINIPROJET1;

import java.util.ArrayList;

public class FibonacciIterative {
    public static void main(String[] args) {

        System.out.println(maSuite(10));
    }

    public static int maSuite(int n){
        ArrayList<Integer> suite= new ArrayList();
        int temp1=0, temp2=1;
        int sum;
        suite.add(temp1);
        suite.add(temp2);
        for (int i= 2; i <= n; i++){
            sum = temp1 + temp2;
            temp1 = temp2;
            temp2 = sum;
            suite.add(sum);
        }
        return suite.get(n);
    }
}
