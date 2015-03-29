package challenges.geometry.polarAngles;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-3-29.
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Point[] points = new Point[N];
        for(int i = 0; i < N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }
        solve(N, points);
    }

    public static void solve(int N, Point[] points){
        calcAngles(N, points);
        calcDist(N, points);
        Arrays.sort(points, new ChainComparator(new AnglesComparator(), new DistComparator()));
        for(int i = 0; i < N; i++){
            System.out.println(points[i].x + " " + points[i].y);
        }
    }

    public static void calcDist(int N, Point[] points){
        for(int i = 0; i < N; i++){
            int x = points[i].x;
            int y = points[i].y;
            points[i].setDist(Math.sqrt(x*x + y*y));
        }
    }

    public static void calcAngles(int N, Point[] points){
        for(int i = 0; i < N; i++){
            int x = points[i].x;
            int y = points[i].y;
            if(x == 0){
                if(y > 0){
                    points[i].setAngles(90);
                }else{
                    points[i].setAngles(270);
                }
                continue;
            }

            if(y == 0){
                if(x > 0){
                    points[i].setAngles(0);
                }else{
                    points[i].setAngles(180);
                }
                continue;
            }
            double theta = Math.atan((1.0) * y / x);
            if(x > 0){
               if(y > 0){
                   points[i].setAngles(theta);
               }else{
                   points[i].setAngles(360 + theta);
               }
            }else{
                points[i].setAngles(180 + theta);
            }
        }
    }
}
class ChainComparator implements Comparator<Point>{
    List<Comparator<Point>> listOfComparators;

    public ChainComparator(Comparator<Point>... comparators){
        listOfComparators = Arrays.asList(comparators);
    }

    @Override
    public int compare(Point p1, Point p2){
        for(Comparator<Point> comparator : listOfComparators){
            int result = comparator.compare(p1, p2);
            if(result != 0){
                return result;
            }
        }
        return 0;
    }
}
class AnglesComparator implements Comparator<Point>{
    @Override
    public int compare(Point p1, Point p2){
        double dif = p1.getAngles() - p2.getAngles();
        double e = 0.000001;
        if(Math.abs(dif) <= e){
            return 0;
        }else if(dif > e){
            return 1;
        }else{
            return -1;
        }
    }
}

class DistComparator implements Comparator<Point>{
    @Override
    public int compare(Point p1, Point p2){
        double dif = p1.getDist() - p2.getDist();
        double e = 0.000001;
        if(Math.abs(dif) <= e){
            return 0;
        }else if(dif > e){
            return 1;
        }else{
            return -1;
        }
    }
}

class Point{
    int x;
    int y;
    double angles;
    double dist;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double getAngles(){
        return angles;
    }

    public void setAngles(double angles){
        this.angles = angles;
    }

    public double getDist(){
        return dist;
    }

    public void setDist(double dist){
        this.dist = dist;
    }
}
