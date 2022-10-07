package MINIPROJET1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Miniprojet1 {
    static ArrayList I = new ArrayList();
    static ArrayList M = new ArrayList();
    static ArrayList R = new ArrayList();
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet
                = workbook.createSheet(" Student Data ");
        XSSFRow row;

        Map<Integer, Object[]> studentData
                = new TreeMap<Integer, Object[]>();


        studentData.put(
                1,
                new Object[] { "FIBONNACI(I)", "ITERATIVE", "RECURSIVE","MATRIX" });


        FibonacciIterative iterative = new FibonacciIterative();
        FibonacciExpMatrix matrix = new FibonacciExpMatrix();
        Recursive recursive = new Recursive();


        int r = 2;
        for(int i = 1; i<2000; i++){
            final long startIterative = System.nanoTime() ;
            iterative.maSuite(i);
            final long endIterative = System.nanoTime() ;
            final long timeIterative = (endIterative - startIterative)/ 1000 ;
            I.add(timeIterative);

            String tRec = "NOT CALCULATED";

            if (i <= 30) {
                final long startRecursive = System.nanoTime() ;
                recursive.Recursive(i);
                final long endRecursive = System.nanoTime() ;
                final long timeRecursive = (endRecursive - startRecursive) / 1000;
                tRec = String.valueOf(timeRecursive);
                R.add(timeRecursive);

            }





            final long startMatrix = System.nanoTime() ;
            matrix.fibonacci(i);
            final long endMatrix = System.nanoTime() ;
            final long timeMatrix = (endMatrix - startMatrix)/ 1000 ;
            M.add(timeMatrix);

            studentData.put(r,new Object[]{String.valueOf(i),String.valueOf(timeIterative),tRec,String.valueOf(timeMatrix)});
            r++;
        }

        Set<Integer> keyid = studentData.keySet();
        int rowid = 0;
        for (int key : keyid) {

            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = studentData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {

                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }
        FileOutputStream out = new FileOutputStream(
                new File("/Users/teobk/Documents/FAC/COMPLEXITE/Miniprojet1.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println(I);
        System.out.println(R);
        System.out.println(M);
    }
}
