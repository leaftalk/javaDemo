package ACWing.数学知识.求组合数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :求组合数II
 * @Author : LeafTalk
 * @Data : 2022/1/27
 */
public class Demo02 {
    static int N = 100010;
    static long[] fact = new long[N];
    static long[] infact = new long[N];
    static int mod = 1000000007;
    //c(a,b) = a! / b!*(a-b)! =a! * qmi(b!) * qmi((a-b)!)
    //先初始化出 fact[] 和 infact[]
    public static void init(){
        fact[0] = 1;
        infact[0] = 1;
        for(int i=1;i<N;i++){
            fact[i] = (i * fact[i-1]) % mod;
            infact[i] = (infact[i-1] * qmi(i,mod-2,mod)) %mod;
        }
    }

    public static long qmi(long a,int b,int c){
        long res = 1;
        while(b>0){
            if((b&1)==1){
                res =(res * a) %c;
            }
            a = (a * a) % c;
            b = b >> 1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
            init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            System.out.println((fact[a] * infact[b])% mod * infact[a-b] % mod);
        }
    }
}
