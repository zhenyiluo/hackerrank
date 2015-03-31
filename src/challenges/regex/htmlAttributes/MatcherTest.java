package challenges.regex.htmlAttributes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zhenyi Luo on 15-3-31.
 */
public class MatcherTest {
    public static void main(String[] args){
        Pattern datePatt = Pattern.compile("(([0-9]{2}) ([0-9]{2})/([0-9]{4}))");
        Matcher m = datePatt.matcher("24 01/1987");
        if (m.matches()) {
            int day   = Integer.parseInt(m.group(2));
            int month = Integer.parseInt(m.group(3));
            int year  = Integer.parseInt(m.group(4));
            System.out.println("day= " + day + "" + " month= " + month + " year= " + year);
        }

    }
}
