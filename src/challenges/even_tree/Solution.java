package challenges.even_tree;

/**
 * Created by Eric on 15-3-8.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[][] arr = new boolean[N][N];
        for(int i = 0; i < M; i++){
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            arr[vertex1 -1][vertex2-1] = true;
            arr[vertex2 -1][vertex1-1] = true;
        }
        int result = 0;
        for(int i = 0; i < N; i++){
            result += solve(i, arr);
        }
        System.out.println(result);
    }
    public static int solve(int vertex, boolean[][] arr){
        int result = 0;
        int N = arr.length;
        for(int i = 0; i< N; i++){
            if( i != vertex && arr[vertex][i]){
                arr[vertex][i] = false;
                arr[i][vertex] = false;
                boolean[] visited = new boolean[N];
                if(getSubTreeNodes(i, arr, visited) % 2 == 0){
                    result++;
                }else{
                    arr[vertex][i] = true;
                    arr[i][vertex] = true;
                }
            }
        }
        return result;
    }
    public static int getSubTreeNodes(int vertex, boolean[][] arr, boolean[] visited){
        int result = 1;
        visited[vertex] = true;
        boolean flag = false;
        int N = arr.length;
        for(int i = 0; i < N && !flag; i++){
            if(i != vertex && arr[vertex][i] && !visited[i]){
                flag = true;
            }
        }
        if(!flag){
            return result;
        }else{
            for(int i = 0; i < N; i++){
                if(i != vertex && arr[vertex][i] && !visited[i]){
                    result += getSubTreeNodes(i, arr, visited);
                }
            }
            return result;
        }
    }
}