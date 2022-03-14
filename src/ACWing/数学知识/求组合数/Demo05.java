package ACWing.数学知识.求组合数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :满足条件的01序列
 * @Author : LeafTalk
 * @Data : 2022/1/28
 */
public class Demo05 {
    static int mod = 1000000007;

    public static long qmi(long a,long b ,long q){
        long res = 1;
        while(b>0){
            if((b&1)==1){
                res = (res * a) %q;
            }
            a =( a*a ) % q;
            b = b>>1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long res=1;

        for(int i=n*2;i>n;i--){
            res = (res * i) % mod;
        }
        for(int i=1;i<=n;i++){
            res = ( res * qmi(i,mod-2,mod) )% mod;
        }

        res = ( res * qmi(n+1,mod-2,mod ) ) % mod;
        System.out.println(res);
    }
}
