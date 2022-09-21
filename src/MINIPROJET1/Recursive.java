public class Recursive {

    public static int Recursive(int n){
        int result ;
        if(n == 0){
            result = 0;
        } else if (n ==1) {
            result = 1;
        }else {
            result = Recursive(n-1)+Recursive(n-2);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(Recursive(2));
    }
}
