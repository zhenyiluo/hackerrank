package challenges.regex.hackerRankLanguage;

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
        if(s.matches("\\d+\\s+(CPP|C|JAVA|PYTHON|PERL|PHP|RUBY|CSHARP|HASKELL|CLOJURE|BASH|SCALA|ERLANG|CLISP|LUA|BRAINFUCK|JAVASCRIPT|GO|D|OCAML|R|PASCAL|SBCL|DART|GROOVY|OBJECTIVEC)")){
            return "VALID";
        }else{
            return "INVALID";
        }
    }
}