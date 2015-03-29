package challenges.regex.detectingValidLatitudeAndLongitude;

import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-3-29.
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < N; i++){
            String s = sc.nextLine();
            System.out.println(solve(s));
        }
    }
    public static String solve(String s){
        String[] ss = s.split(",\\s");
        String s1 = ss[0].substring(1);
        String s2 = ss[1].substring(0, ss[1].length()-1);
        if(hasExtraDot(s1) || hasExtraDot(s2)){
            return "Invalid";
        }
        if(hasLeadingZero(s1) || hasLeadingZero(s2)){
            return "Invalid";
        }
        double d1 = Double.valueOf(s1);
        double d2 = Double.valueOf(s2);
        if( Double.compare(d1, -90) < 0 || Double.compare(d1, 90) >0 || Double.compare(d2, -180) < 0
                || Double.compare(d2, 180) > 0){
            return "Invalid";
        }else{
            return "Valid";
        }
    }
    public static boolean hasExtraDot(String s){
        if(s.matches(".*\\.")){
            return true;
        }else{
            return false;
        }
    }
    public static boolean hasLeadingZero(String s){
        if(s.matches("\\+*|\\-*0.*")){
            return true;
        }else{
            return false;
        }
    }
}
