package challenges.regex.splitNumber;

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
            String[] s = sc.nextLine().split("-|\\s");
            System.out.println("CountryCode=" + s[0] + ",LocalAreaCode=" + s[1] + ",Number=" + s[2]);
        }
    }
}
