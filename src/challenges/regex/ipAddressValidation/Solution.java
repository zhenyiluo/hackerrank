package challenges.regex.ipAddressValidation;

/**
 * Created by Zhenyi Luo on 15-3-29.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < N; i++){
            String s = sc.nextLine();
            System.out.println(solve(s));
        }
    }
    public static String solve(String s){
        String ret;
        String[] sp = s.split("\\.");
        if(sp.length == 4){
            if(isIPv4(sp)){
                ret = "IPv4";
            }else{
                ret = "Neither";
            }
        }else{
            String[] sp1 = s.split(":");
            if(sp1.length == 8){
                if(isIPv6(sp1)){
                    ret = "IPv6";
                }else{
                    ret = "Neither";
                }
            }else{
                ret = "Neither";
            }
        }
        return ret;
    }
    public static boolean isIPv4(String[] s){
        int len = s.length;
        for(int i = 0; i < len; i++){
            String tmp = s[i];
            int num = Integer.valueOf(tmp);
            if(num > 255){
                return false;
            }
        }
        return true;
    }
    public static boolean isIPv6(String[] s){
        int len = s.length;
        for(int i = 0; i < len; i++){
            String tmp = s[i];
            if(!tmp.matches("[0-9a-f]{1,4}")){
                return false;
            }
        }
        return true;
    }
}