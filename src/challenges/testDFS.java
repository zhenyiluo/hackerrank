package challenges;

/**
 * Created by Zhenyi Luo on 15-4-4.
 */
public class testDFS {
    public static void main(String[] args){
        long l1 = System.currentTimeMillis();
        System.out.println(dfs(15200));
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);
    }
    public static long dfs(int n){
        if(n ==1){
            return 1;
        }else{
            return 2* dfs(n-1);
        }
    }
}
