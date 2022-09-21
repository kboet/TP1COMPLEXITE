public class FibonacciExpMatrix {
    static int[][] matrix = {{0,1},{1,1}};
    static int[][]fibonacciFirstValue= {{0},{1}};


    public static int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2){
        int [][] result = new int[matrix1.length][matrix1.length];
        for(int i = 0; i <matrix1.length; i++){
            for(int j = 0; j < matrix1.length; j++){
                for(int k = 0; k < matrix1.length; k++){
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;


    }
    public static int[][] matrixPow(int[][] matrix , int n){
        int [][] result = matrix;
        // check if n == 2^k
        double v = Math.log(n) / Math.log(2);
        if(v %1 == 0){
            for (int a = 1; a <= v; a++){
                result = matrixMultiplication(result,result);
            }
            return result;
        }
        if (n%2 == 0){
            result = matrixMultiplication(result,result);
            result = matrixPow(result, n/2);
            return result;
        }
        else result = matrixMultiplication(result, matrixPow(result,n-1));
        return result;
    }


    public static int[][] matrix2x2x2x1(int[][] m1, int[][]m2){
        return new int[][]{
                {m1[0][0]*m2[0][0] +m1[0][1]*m2[1][0] },
                {m1[1][0]*m2[0][0] +m1[1][1]*m2[1][0] }
        };
    }

    public static int[][]fibonacci (int n){
        int[][]result = new int[2][1];
        result = matrix2x2x2x1(matrixPow(matrix,n),fibonacciFirstValue);
            return result;
    }

    public static void main(String[] args) {


        int mat[][] = fibonacci(15);
        for (int i = 0; i < mat.length; i++)

        // Loop through all elements of current row
        for (int j = 0; j < mat[i].length; j++)
            System.out.print(mat[i][j] + " ");
    }
}
