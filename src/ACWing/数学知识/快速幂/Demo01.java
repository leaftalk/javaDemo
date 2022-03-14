package ACWing.数学知识.快速幂;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :快速幂
 * @Author : LeafTalk
 * @Data : 2021/12/31
 */
public class Demo01 {

    // a^b % p , b可以表示为二进制（...10110 = 2^1+2^2+2^4....） => a^b = a^(2^1) * a^(2^2) * a^(2^4) ....
    //  ( a^(2^1) ) %p = A ,( a^(2^2) ) %p = B ..... ( a^(2^k) ) %p = C
    // ( a^b % p ) =  ( A * B .... *C ) % p
    public static long qmi(long a,long b,long p){
        long res =1L;
        while(b>0){
            if((b & 1)==1){
                    res = res * a % p;
            }

            a = (a * a) % p ;
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
            long p = Long.parseLong(str[2]);
            System.out.println(qmi(a, b, p));

        }
    }
}
