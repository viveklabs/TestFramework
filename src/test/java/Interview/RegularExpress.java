package Interview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpress {

    public static void main (String[] args) {

        String input = "[2024-08-01 10:30:05] ERROR - Connection timeout for service_A";

        Pattern p = Pattern.compile("^(\\[\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\\])\\s(\\w+)\\s\\-\\s(.*)$");
        Matcher m = p.matcher(input);
        while (m.find()){
            System.out.println(m.group(0)); // Output :entire input
            System.out.println(m.group(1)); // Timestamp
            System.out.println(m.group(2)); // Logger
            System.out.println(m.group(3)); // Message
        }

        String line = "My Email address is user12-wes@domain.com and it is active";
        Pattern p1 = Pattern.compile("[\\w\\d\\-]+@\\w+\\.\\w+");
        Matcher m1 = p1.matcher(line);
        while (m1.find()) {
            System.out.println(m1.group()); // output = user12-wes@domain.com
        }
    }
}
