package challenges.search.countLuck;

/**
 * Created by Zhenyi Luo on 15-3-21.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] c = new char[n][m];
            for(int j = 0; j < n; j++){
                c[j] = sc.next().toCharArray();
            }
            int k = sc.nextInt();
            System.out.println(solve(n, m, k, c));
        }
    }
    public static String solve(int n, int m, int k, char[][] c){
        boolean[][] flag = new boolean[n][m];
        Queue<Element> q = new LinkedList<Element>();
        Element start = new Element(-1, -1, 0);
        Element end = new Element(-1, -1, 0);
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(c[i][j] == 'M'){
                    start.row = i;
                    start.col = j;
                }
                if(c[i][j] == '*'){
                    end.row = i;
                    end.col = j;
                }
            }
        }
        q.add(start);
        flag[start.row][start.col] = true;
        while(!q.isEmpty()){
            Element e = q.poll();
            int available = 0;
            if(e.row == end.row && e.col == end.col){
                count = e.count;
                break;
            }
            LinkedList<Element> tmp = new LinkedList<Element>();
            for(int i = 0; i< 4; i++){
                int newRow = e.row + dx[i];
                int newCol = e.col + dy[i];
                if(!isOutOfRange(newRow, newCol, n, m) && !flag[newRow][newCol] && c[newRow][newCol] !='X'){
                    tmp.add(new Element(newRow, newCol, e.count));
                    flag[newRow][newCol] = true;
                    available++;
                }
            }
            if(available > 1){
                for(Element ee : tmp){
                    ee.count ++;
                }
            }
            q.addAll(tmp);
        }
        if(count == k){
            return "Impressed";
        }else{
            return "Oops!";
        }
    }
    public static boolean isOutOfRange(int x, int y, int n, int m){
        if(x < 0 || y <0 || x>=n || y >=m){
            return true;
        }
        return false;
    }
}
class Element{
    int row;
    int col;
    int count;
    public Element(int row, int col, int count){
        this.row = row;
        this.col = col;
        this.count = count;
    }
}