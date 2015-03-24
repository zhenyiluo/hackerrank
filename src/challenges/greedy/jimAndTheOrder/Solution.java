package challenges.greedy.jimAndTheOrder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-3-24.
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Element[] elements = new Element[n];
        for(int i = 0; i < n; i++){
            int t = sc.nextInt();
            int d = sc.nextInt();
            int sum = t+d;
            elements[i] = new Element(t, d, sum, i);
        }

        Arrays.sort(elements, new ChainedComparators(new SumComparator(), new IdComparator()));
        for(Element e : elements){
            System.out.print((e.id+1) + " ");
        }
        System.out.println();
    }
}
class Element{
    int t;
    int d;
    int sum;
    int id;
    public Element(int t, int d, int sum, int id){
        this.t = t;
        this.d = d;
        this.sum = sum;
        this.id = id;
    }
}
class SumComparator implements Comparator<Element> {
    @Override
    public int compare(Element e1, Element e2){
        return e1.sum - e2.sum;
    }
}

class IdComparator implements Comparator<Element> {
    @Override
    public int compare(Element e1, Element e2){
        return e1.id - e2.id;
    }
}

class ChainedComparators implements Comparator<Element>{
    private List<Comparator<Element>> listComparator;
    public ChainedComparators(Comparator<Element>... comparators){
        this.listComparator = Arrays.asList(comparators);
    }
    @Override
    public int compare(Element e1, Element e2){
        for(Comparator<Element> comparator : listComparator){
            int result = comparator.compare(e1, e2);
            if(result != 0){
                return result;
            }
        }
        return 0;
    }
}