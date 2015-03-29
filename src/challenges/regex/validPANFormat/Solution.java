package challenges.regex.validPANFormat;

import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-3-29.
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            String s = sc.next();
            if(s.matches("[A-Z]{5}\\d{4}[A-Z]")){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
