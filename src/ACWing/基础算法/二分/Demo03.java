package ACWing.基础算法.二分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 求数的三次方根
 * @Author : LeafTalk
 * @Data : 2021/9/27
 */
public class Demo03 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Double a = Double.parseDouble(in.readLine());
        double l =-1000,r = 1000;
        while(r-l > 1e-8){
            double mid = (l+r)/2;
            if(mid*mid*mid <= a) l =mid;
            else r = mid;
        }
        System.out.printf("%.6f\n",l);
    }
}
