package challenges.regex.programmingLanguageDetection;

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
        Pattern java = Pattern.compile("import java");
        Pattern python = Pattern.compile("\\sdef\\s|print\\s");
        Pattern c = Pattern.compile("#include");

        Matcher mJava = java.matcher(s);
        Matcher mPython = python.matcher(s);
        Matcher mC = c.matcher(s);

        if(mJava.find()){
            System.out.println("Java");
        }else if(mPython.find()){
            System.out.println("Python");
        }else if(mC.find()){
            System.out.println("C");
        }
    }
}
