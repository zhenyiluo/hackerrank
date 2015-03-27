package challenges.greedy.algorithmicCrush;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-3-26.
 */
public class Solution {
    public static void main(String[] ags){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Element> list = new ArrayList<Element>();
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            list.add(new Element(a, k));
            list.add(new Element(b+1, -k));
        }
        System.out.println(solve(list));
    }
    public static long solve(ArrayList<Element> list){
        long ret = 0;
        long tmp = 0;
        int len = list.size();

        Collections.sort(list, new Comparator<Element>(){
            @Override
            public int compare(Element e1, Element e2){
                return e1.index - e2.index;
            }
        });

        for(int i = 0; i < len;){
            int j = i;
            while( j < len && list.get(j).index == list.get(i).index){
                tmp += list.get(j).val;
                j++;
            }
            ret = Math.max(ret, tmp);
            i = j;
        }
        return ret;
    }
}

class Element{
    int index;
    int val;
    public Element(int index, int val){
        this.index = index;
        this.val = val;
    }
}
