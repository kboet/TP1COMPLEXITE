package MINIPROJET2;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static MINIPROJET2.ZoneVide.*;


public class Miniprojet2 {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet
                = workbook.createSheet(" Student Data ");
        XSSFRow row;

        Map<Integer, Object[]> studentData
                = new TreeMap<Integer, Object[]>();


        studentData.put(
                1,
                new Object[] { "NOMBRE de SOMMET", "ZONE VIDE MAXIMALE", "ZONE VIDE MAXIMUM COMPLETE", "ZONE VIDE MAXIMUM INCOMPLETE" });


        int r = 2;

        String maximumTime = "NOT CALCULATED";
        for (int i = 2; i<=50; i++ ){
            int[][] G = generateGraph(i);
            if (i<15) {
                final long maximumStart = System.nanoTime();
                MaximumVide(G);
                final long maximumEnd = System.nanoTime();
                maximumTime = String.valueOf((maximumEnd - maximumStart) / 1000);
            }

            final long maximalStart = System.nanoTime();
            zoneMaximale(G);
            final long maximalEnd = System.nanoTime();
            final long maximalTime = (maximalEnd - maximalStart) / 1000;
            final long maximalStart2 = System.nanoTime();
            zoneMaximumInc(G);
            final long maximalEnd2 = System.nanoTime();
            final long maximalTime2 = (maximalEnd2 - maximalStart2) / 1000;

            studentData.put(r,new Object[]{String.valueOf(i),String.valueOf(maximalTime), maximumTime,String.valueOf(maximalTime2)});
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
                new File("/Users/teobk/Documents/FAC/COMPLEXITE/Miniprojet2.xlsx"));
        workbook.write(out);
        out.close();

    }
}
