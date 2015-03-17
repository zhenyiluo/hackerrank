package challenges.strings.morgan_and_a_string;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            String a = sc.next();
            String b = sc.next();
            System.out.println(solve(a, b));
        }
    }
    public static String solve(String a, String b){
        int pa = 0;
        int pb = 0;
        int aa = -1;
        int bb = -1;
        StringBuilder result = new StringBuilder("");
        while(pa < a.length() && pb < b.length()){
            if(a.charAt(pa) < b.charAt(pb)){
                result.append(a.charAt(pa));
                pa++;
            }else if(b.charAt(pb) < a.charAt(pa)){
                result.append(b.charAt(pb));
                pb++;
            }else{
                if(pa < aa){
                    result.append(a.charAt(pa));
                    pa++;
                }else if (pb < bb){
                    result.append(b.charAt(pb));
                    pb++;
                }else{
                    int tmpa = pa;
                    int tmpb = pb;
                    while(tmpa < a.length() && tmpb < b.length() && a.charAt(tmpa) == b.charAt(tmpb)){
                        tmpa++;
                        tmpb++;
                    }
                    if(tmpa < a.length() && tmpb < b.length()){
                        if(a.charAt(tmpa) < b.charAt(tmpb)){
                            aa = tmpa;
                            result.append(a.charAt(pa));
                            pa++;
                        }else{
                            bb = tmpb;
                            result.append(b.charAt(pb));
                            pb++;
                        }
                    }else {
                        if((a+ b.substring(pb)).substring(pa).compareTo((b+ a.substring(pa)).substring(pb)) <= 0){
                            aa = longestCommon(pa, pb, a, b);
                            result.append(a.charAt(pa));
                            pa++;
                        }else{
                            bb = longestCommon(pb, pa, b, a);
                            result.append(b.charAt(pb));
                            pb++;
                        }
                    }
                }
            }
        }
        if(pa < a.length()){
            result.append(a.substring(pa));
        }
        if(pb < b.length()){
            result.append(b.substring(pb));
        }
        return result.toString();
    }
    public static int longestCommon(int index1, int index2, String s1, String s2){
        while(index1 < s1.length() && index2 < s2.length() && s1.charAt(index1) == s2.charAt(index2)){
            index1++;
            index2++;
        }
        return index1-1;
    }

//    Failed test case:
//    1
//    YZZAZZC ZZAZZC
}