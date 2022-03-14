package ACWing.数学知识.快速幂;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 快速幂求逆元（p为质数时使用）
 * @Author : LeafTalk
 * @Data : 2021/1/5
 */
public class Demo02 {
    //若整数 b，m 互质，并且对于任意的整数 a，如果满足 b|a，则存在一个整数 x，使得 a/b ≡ a×x(mod m)，则称 x 为 b 的模 m 乘法逆元，记为 b^−1(mod m)。
    //b 存在乘法逆元的充要条件是 b 与模数 m 互质.
    // a/b ≡ a×x(mod m) 两边同乘以 b ; a ≡ a * x * b (mod m) ;则 x * b ≡ 1 (mod m)
    //费马定理： b^p-1 ≡ 1 (mod p)(p为质数)
    //由费马定理得  b * b^m-2 ≡ 1 (mod m) 得出 b 模 m的逆元为 b^m-2（前提 b,m互质）
    public static long qmi(long a,long b,long c){
            long res = 1L;
            while(b>0){
                if((b&1) == 1){
                    res = (res * a) % c;
                }
                a = ( a * a ) % c;
                b >>= 1;
            }
            return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String[] str = br.readLine().split(" ");
            long a = Long.parseLong(str[0]);
            long b = Long.parseLong(str[1]);
            if(a%b ==0){
                System.out.println("impossible");
            }else{
               long res = qmi(a,b-2,b);
                System.out.println(res);
            }
        }
    }
}
