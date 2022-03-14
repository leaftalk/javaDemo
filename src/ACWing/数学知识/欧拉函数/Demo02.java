package ACWing.数学知识.欧拉函数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :筛法求欧拉函数
 * @Author : LeafTalk
 * @Data : 2021/12/30
 */
public class Demo02 {
    static int N;
    static int count;
    static int[] primes = new int[N];
    static boolean[] std = new boolean[N];
    static int[] phi = new int[N];

    public static void euler(int n){
        phi[1]= 1;
        for(int i=2; i<= n ;i++){
            if(!std[i]){
                primes[count++] = i;
                phi[i] = i-1; //质数的欧拉函数为i-1
            }
            for(int j=0;primes[j] <= n/i;j++){
                int t =primes[j] *i;
                std[t] = true;
                if(i%primes[j]==0){
                    //primes[j]为i的最小质因子，pj*i分解的因数同i，Ф(pj*i) =pj*i*(1-1/p1)*...(1-1/pk)= Φ(i)*pj
                    phi[t] = phi[i]*primes[j];
                    break;
                }
                phi[t] = phi[i]*(primes[j]-1);
                //pj不是i的质因子，pj*i的质因子比i的质因子多一个pj，Ф(pj*i) =pj*i*(1-1/p1)*...(1-1/pk)*(1-1/pj)= Φ(i)*pj*(1-1/pj)
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        euler(n);
        long res =0L;
        for (int i = 1; i <= n; i++) {
            res +=phi[i];
        }
        System.out.println(res);

    }
}
