package challenges.search_combinatorics.theQuickestWayUp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-3-23.
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());
        for(int i = 0; i < T; i++){
            String[] sNum = sc.nextLine().split(",");
            int l = Integer.valueOf(sNum[0]);
            int s = Integer.valueOf(sNum[1]);
            int[] startLadder = new int[l];
            int[] endLadder = new int[l];
            int[] startSnake = new int[s];
            int[] endSnake = new int[s];
            String[] ll = sc.nextLine().split("\\s");
            for(int j = 0; j < l; j++){
                String[] tmp = ll[j].split(",");
                startLadder[j] = Integer.valueOf(tmp[0]);
                endLadder[j] = Integer.valueOf(tmp[1]);
            }
            String[] ss = sc.nextLine().split("\\s");
            for(int j = 0; j < s; j++){
                String[] tmp = ss[j].split(",");
                startSnake[j] = Integer.valueOf(tmp[0]);
                endSnake[j] = Integer.valueOf(tmp[1]);
             }
            System.out.println(solve(l, startLadder, endLadder, s, startSnake, endSnake));
        }
    }

    public static int solve(int l, int[] startLadder, int[] endLadder, int s, int[] startSnake, int[] endSnake){
        int result = -1;
        Queue<Element> q = new LinkedList<Element>();
        boolean[] flag = new boolean[101];

        q.add(new Element(1, 0));
        flag[1] = true;
        while(!q.isEmpty()){
            Element e = q.poll();
            if(e.n == 100){
                result = e.level;
                break;
            }
            for(int i = 1; i <= 6; i++){
                if(e.n + i <= 100 && !flag[e.n+i]){
                    flag[e.n+i] = true;
                    q.add(new Element(e.n+i, e.level+1));
                    int ladder = check(e.n+i, startLadder, endLadder);
                    if(ladder != -1 && !flag[ladder]){
                        flag[ladder] = true;
                        q.add(new Element(ladder, e.level+1));
                    }
                    int snake = check(e.n+i, startSnake, endSnake);
                    if(snake != -1 && !flag[snake]){
                        flag[snake] = true;
                        q.add(new Element(snake, e.level+1));
                    }
                }
            }
        }

        return result;
    }
    public static int check (int n, int[] a, int[] b){
        int result = -1;
        for(int i = 0; i < a.length; i++){
            if(n == a[i]){
                result = b[i];
                break;
            }
        }
        return result;
    }

}
class Element{
    int n;
    int level;
    public Element(int n, int level){
        this.n = n;
        this.level = level;
    }
}
