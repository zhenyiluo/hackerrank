package challenges.strings.panagram;

/**
 * Created by Eric on 15-3-14.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(isPanagram(s)){
            System.out.println("pangram");
        }else{
            System.out.println("not pangram");
        }
    }
    public static boolean isPanagram(String s){
        String tmp = s.toLowerCase();
        int mask = 0;
        for(int i = 0; i < tmp.length(); i++){
            if(tmp.charAt(i) != ' '){
                mask |= 1 << (tmp.charAt(i) - 'a');
            }
        }
        boolean flag = true;
        for(int i = 0; i < 26 && flag; i ++){
            if((mask & (1 << i)) == 0){
                flag = false;
            }
        }
        return flag;
    }
}