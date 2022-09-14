import java.lang.reflect.Array;
import java.util.ArrayList;

public class Fibonacci {
    public static void main(String[] args) {
        maSuite(10);
    }

    public static ArrayList maSuite(int n){
        ArrayList suite= new ArrayList();
        int temp1=0, temp2=1;
        int sum;
        for (int i= 0; i <= n; i++){
            sum = temp1 + temp2;
            temp1 = temp2;
            temp2 = sum;
            suite.add(sum);
            System.out.println(suite.get(i));
        }
        return suite;
    }
}
