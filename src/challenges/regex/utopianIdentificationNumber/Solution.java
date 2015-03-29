package challenges.regex.utopianIdentificationNumber;

/**
 * Created by Zhenyi Luo on 15-3-29.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            String s = sc.next();
            if(s.matches("[a-z]{0,3}\\d{2,8}[A-Z]{3,}")){
                System.out.println("VALID");
            }else{
                System.out.println("INVALID");
            }
        }
    }
}
