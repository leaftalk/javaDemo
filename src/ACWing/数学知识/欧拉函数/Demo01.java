package ACWing.数学知识.欧拉函数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description :欧拉函数 求 互质数个数
 * @Author : LeafTalk
 * @Data : 2021/12/29
 */
public class Demo01 {
    static Map<Integer,Integer> map;

    //欧拉函数：1到n中与n互质的数的个数为欧拉函数，记为 Ф(N)
    //N = p1^c1 * p2^c2 *…* pk^ck;
    //Φ(N) = N * (1 - p1) * (1-p2) * (1-p3) ... (1-pk)

    public static int getPrime(int n ){
        int res = n;
        map = new HashMap<>();
        for(int i=2;i<= n/i;i++){
            if(n %i ==0){
                res = res/i * (i-1);
                while(n % i ==0){
                    n /= i;
                    map.put(i, map.getOrDefault(i,0)+1);
                }
            }

        }
        if(n>1){
            res = res/n * (n-1);
            map.put(n,1);
        }
        return res;
    }

    //求 质因子 时间复杂度 o（√ai）,一共有n个数，总共时间复杂度为 n*√ai
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            while(n-->0){
                int m = Integer.parseInt(br.readLine());
                System.out.println(getPrime(m));
            }
    }
}
