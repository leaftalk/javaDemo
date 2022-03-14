package ACWing.数学知识.中国剩余定理;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 表达整数的奇怪方式
 * @Author : LeafTalk
 * @Data : 2022/1/11
 */
public class Demo01 {
    static long x=0;
    static long y=0;
    //Mi = (m1*m2*m3..*mi...mk)/mi
    //Mi^-1 表示 Mi模mi的逆
    // x = (a1*M1*M1^-1)*(a2*M2*M2^-1)*(a3*M3*M3^-1)....(ak*Mk*Mk^-1)


    public static long exgcd(long a,long b){
            if(b ==0){
                x=1;
                y=0;
                return a;
            }
            long gcd = exgcd(b,a%b);
            long x1 = x;
            long y1 = y;
            x = y1;
            y = x1 - a/b * y1;
        return gcd;
    }

    public static long inv(long a,long b){
        exgcd(a,b);
        return (x*b+b)%b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n]; //模数数组
        int[] m = new int[n]; // 余数数组
        int i =0;

        long r = 1L; //模数的乘积
        int n2 = n;
        while(n2-->0){
            String[] arr = br.readLine().split(" ");
            int ai = Integer.parseInt(arr[0]);
            r *=  ai;
            a[i] = ai;
            m[i++] = Integer.parseInt(arr[1]);
        }

        long res = 0L;
        for (int j = 0; j < n; j++) {
            long rj = r/a[j];
            res += (rj * m[j] *inv(rj,a[j])) % r;
        }
        System.out.println(res % r);
    }
}
