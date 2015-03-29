package challenges.geometry.stars;

/**
 * Created by Zhenyi Luo on 15-3-29.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Vertex[] vertices = new Vertex[N];
        for(int i = 0; i < N; i++){
            long x = sc.nextLong();
            long y = sc.nextLong();
            long v = sc.nextLong();
            vertices[i] = new Vertex(x, y, v);
        }
        System.out.println(solve(N, vertices));
    }
    public static long solve(int N, Vertex[] vertices){
        if(N == 1){
            return 0;
        }
        if(N == 2){
            return Math.min(vertices[0].v ,vertices[1].v);
        }

        long ret = 0;
        long minDiff = Long.MAX_VALUE;

        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < N; j++){
                long sum1 = 0;
                long sum2 = 0;
                for(int k = 0; k < N; k++){
                    if(k != i && k != j){
                        long val = (vertices[k].x - vertices[i].x)*(vertices[j].y - vertices[i].y) -
                                (vertices[k].y - vertices[i].y)*(vertices[j].x - vertices[i].x);
                        if(val > 0){
                            sum1 += vertices[k].v;
                        }else{
                            sum2 += vertices[k].v;
                        }
                    }
                }
                if(Math.abs(sum1 + vertices[i].v - sum2 - vertices[j].v) < minDiff){
                    minDiff = Math.abs(sum1 + vertices[i].v - sum2 - vertices[j].v);
                    ret = Math.min(sum1 + vertices[i].v, sum2 + vertices[j].v);
                }
                if(Math.abs(sum1 + vertices[j].v - sum2 - vertices[i].v) < minDiff){
                    minDiff = Math.abs(sum1 + vertices[j].v - sum2 - vertices[i].v);
                    ret = Math.min(sum1 + vertices[j].v, sum2 + vertices[i].v);
                }
            }
        }
        return ret;
    }
}

class Vertex{
    long x;
    long y;
    long v;
    public Vertex(long x, long y, long v){
        this.x = x;
        this.y = y;
        this.v = v;
    }
}