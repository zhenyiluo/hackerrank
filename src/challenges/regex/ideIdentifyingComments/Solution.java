package challenges.regex.ideIdentifyingComments;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zhenyi Luo on 15-4-1.
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder("");
        while(sc.hasNextLine()){
            sb.append(sc.nextLine() + "\n");
        }
        solve(sb.toString());
    }

    public static void solve(String s){
        Pattern pattern = Pattern.compile("(//[^\n]+|/\\*+((([^\\*])+)|([\\*]+(?!/)))[*]+/)");
        Matcher matcher = pattern.matcher(s);
        StringBuilder ret = new StringBuilder("");
        while(matcher.find()){
            ret.append(matcher.group(1) + "\n");
        }
        String[] retToS = ret.toString().split("\n");
        for(int i = 0; i < retToS.length; i++){
            retToS[i] = retToS[i].trim();
            if(retToS[i].length()>=0){
                System.out.println(retToS[i]);
            }
        }
    }
}
