package challenges.regex.stackExchangeScraper;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-3-29.
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        while(sc.hasNextLine()){
            list.add(sc.nextLine());
        }
        System.out.println(solve(list));
    }
    public static String solve(ArrayList<String> list){
        StringBuilder ret = new StringBuilder("");
        for(String s : list){
            if(s.contains("id=\"question-summary-")){
                String[] tmp1 = s.split("id=\"question-summary-");
                String[] tmp2 = tmp1[1].split("\"");
                ret.append(tmp2[0] + ";");
            }
            if(s.contains("<h3>[")){
                String[] tmp1 = s.split("<h3>\\[");
                String[] tmp2 = tmp1[1].split("\\]\\(");
                ret.append(tmp2[0]+ ";");
            }
            if(s.contains("question-hyperlink\">")){
                String[] tmp1 = s.split("question-hyperlink\">");
                String[] tmp2 = tmp1[1].split("</a>");
                ret.append(tmp2[0]+";");
            }
            if(s.contains("relativetime")){
                String[] tmp1 = s.split("relativetime\">");
                String[] tmp2 = tmp1[1].split("<");
                ret.append(tmp2[0] + "\n");
            }
        }
        return ret.toString();
    }
}
