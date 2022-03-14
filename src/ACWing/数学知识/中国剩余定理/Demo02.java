package ACWing.数学知识.中国剩余定理;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :
 * @Author : LeafTalk
 * @Data : 2022/1/12
 */
public class Demo02 {
    public static long exgcd(long a,long b,long[] x,long[] y){
        if(b ==0){
            x[0]=1;
            y[0] = 0;
            return a;
        }
        long gcd = exgcd(b,a%b,y,x);
        y[0] = y[0] - a/b * x[0];
        return gcd;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        long a1 = Long.parseLong(str[0]);
        long m1 = Long.parseLong(str[1]);

        while(n-->1){
            String[] str02 = br.readLine().split(" ");
            long a2 = Long.parseLong(str02[0]);
            long m2 = Long.parseLong(str02[1]);
            long[] k1 =new long[1];
            long[] k2 =new long[1];
            long d = exgcd(a1,-a2,k1,k2); // k1*a1 +k2*(-a2) =gcd(a1,-a2) = d
            if((m2-m1)%d!=0){
                System.out.println(-1);
                return;
            }
            k1[0] *=  (m2-m1)/d; //a1* k1*((m2-m1)/d)  + (-a2) * k2 *((m2-m1)/d) = d* (m2-m1)/d =m2-m1
            long t  = a2/d;
            k1[0] = (k1[0]%t +t )%t; // k1 = (k1 + k*t)
            m1 = k1[0] *a1+ m1;
            a1 = Math.abs(a1*a2/d);

        }
        System.out.println((m1%a1+a1)%a1);  // x = a1(mod m1)
    }
}
