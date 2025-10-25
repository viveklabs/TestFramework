package Interview;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String[] args) throws IOException {

        List<String> l1 = new ArrayList<>(Arrays.asList("apple","orange","banana","apple","banana","grapes","grapes"));

        Map<String,Integer> cMap = new HashMap<>();
        for (String c : l1) {
            cMap.put(c,cMap.getOrDefault(c,0)+1);
        }

        for (Map.Entry<String,Integer> entry : cMap.entrySet()){
            System.out.println(entry.getKey() + " : "+ entry.getValue());
        }

        System.out.println("---------------------------------");
        List<String> l2 = new ArrayList<>(Arrays.asList("apple","orange","banana","grapes"));

        Map<String,Integer> cMap2 = l2.stream().collect(Collectors.toMap(nKey -> nKey , String::length));

        for (Map.Entry<String,Integer> entry : cMap2.entrySet()){
            System.out.println(entry.getKey() + " : "+ entry.getValue());
        }

        /// //////////

        String input = "aabbcccd" ; //-> Output: 'aa2bb2ccc3d1'
        char[] inputArr = input.toCharArray();

        Map<String,Integer> charMap = new HashMap<>();
        for (char t : inputArr){
            charMap.put(String.valueOf(t),charMap.getOrDefault(String.valueOf(t),0)+1);
        }
        StringBuilder sb = new StringBuilder();
        char firstChar = inputArr[0];
        char lastChar = inputArr[inputArr.length - 1];
        for (char t : inputArr){
            if (t != firstChar){
                sb.append(charMap.get(String.valueOf(firstChar)));
            }
            sb.append(t);
            firstChar = t;
        }
        sb.append(charMap.get(String.valueOf(lastChar)));

        System.out.println(sb);

        /// /////////////////

        // input [0, 1, 0, 3, 12], output will be [1, 3, 12, 0, 0].

        int[] arr1 = {0,1,0,0,12,0,0,1,3,12,0,0};
        int[] arr2 = new int[arr1.length];
        int arrLength = arr1.length;
        int count = 0;
        for (int i=0;i<arrLength;i++){
            if (arr1[i] != 0){
                arr2[count] = arr1[i];
                count++;
            }
        }
        System.out.println(Arrays.toString(arr2));

        /// ///////////////////

        InputStream ip = Files.newInputStream(Paths.get("src/test/java/TestData/TestData.xlsx"));

        Workbook eb = new XSSFWorkbook(ip);
        Sheet sheet = eb.getSheet("Sheet1");
        Iterator<Row> rowIt = sheet.rowIterator();
        while (rowIt.hasNext()) {
            Row currentRow = rowIt.next();
            if (currentRow.getRowNum() == 0) {
                continue;
            }
            Iterator<Cell> cellIt = currentRow.cellIterator();
            while (cellIt.hasNext()) {
                System.out.print(cellIt.next() + " ");
            }
            System.out.println();
        }

        /// //////////////////

        String s1 = "This is vivek";
        char[] c1 = s1.toCharArray();
        HashSet<Character> hs = new HashSet<>();
        for (char cc : c1){
            if (cc != ' '){
                hs.add(cc);
            }
        }
        int ccount = 0;
        for (char t : hs) {
            for (int i = 0; i < c1.length; i++) {
                if (c1[i] == t ) {
                    ccount++;
                }
            }
            System.out.println(t +" : "+ ccount);
            ccount = 0;
        }
    }
}
