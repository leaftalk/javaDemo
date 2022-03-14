package ACWing.数学知识.约数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description :求约数个数
 * @Author : LeafTalk
 * @Data : 2021/12/26
 */
public class Demo02 {
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

    //约束个数=（a1+1）*（a2+1）*（a3+1）...（ak+1）
    //N=k1^a1+k2^a2....+kn^ak
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
             ret =ret * (res.get(a)+1)  % mod;
        }

        System.out.println(ret);
    }
}
