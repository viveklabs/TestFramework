package Interview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HSBCInterview {

    public static void main(String[] args) {

        String input = "My name is Vivek";

        char[] caseArr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean isConv = false;

        for (char c : caseArr) {
            Pattern p = Pattern.compile("[a-z]");
            Matcher m = p.matcher(String.valueOf(c));
            while (m.find()) {
                sb.append(m.group(0).toUpperCase());
                isConv = true;
            }
            if (!isConv){
                sb.append(String.valueOf(c).toLowerCase());
            }
            isConv = false;
        }

        System.out.println(sb);


       // Output = "yM eman si keviV";
        StringBuilder outputString = new StringBuilder();

        String[] strArr = input.split("\\s");

        for (String s : strArr) {
            char[] charArr = s.toCharArray();
            String temp = "";
            for (int i= charArr.length-1;i>=0;i--){
                temp = temp + charArr[i];
            }
            outputString.append(temp).append(" ");
        }
            System.out.println(outputString.toString());


        /// /////

        String tranInput = "Your transaction is successful. Ten reference no ABCDE12345, please use it going forward";

        String pattern = "reference no\\s+([a-zA-Z0-9]+),";

        Pattern p1 = Pattern.compile(pattern);
        Matcher m1 = p1.matcher(tranInput);
        while (m1.find()) {
            System.out.println(m1.group(1));
        }
    }
}
