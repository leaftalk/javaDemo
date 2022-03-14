package ACWing.数学知识.约数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description :约数之和
 * @Author : LeafTalk
 * @Data : 2021/12/26
 */

//基本思路：
//    如果 N=p1^c1 * p2^c2 *…* pk^ck;
//    约数个数：(c1+1) * (c2+1) * …* (ck+1)
//    约数之和： (p1^0+p1^1+…+p1^c1)∗…∗(pk^0+pk^1+…+pk^ck)
public class Demo03 {
    static int mod =(int)1e9+7;
    static Map<Integer,Integer> res = new HashMap<>();

    public static void divisor(int n){
        if(n ==1){
            res.put(1,1);
        }
        for(int i=2;i<= n/i;i++){
            int count =0;
            while(n%i==0){
                n /= i;
                count++;
            }
            res.put(i,res.getOrDefault(i,0)+count);
        }
        if(n>1){
            res.put(n,res.getOrDefault(n,0)+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            int m = Integer.parseInt(br.readLine());
            divisor(m);
        }
        //此处用long类型
        long ret =1L;
        for(int a : res.keySet()){
            int b = res.get(a);
            long t = 1L;
            for (int i = 0; i < b; i++) {
                t = (t * a  +1) %mod;
            }
            ret =ret * t % mod ;
        }

        System.out.println(ret);
    }
}
