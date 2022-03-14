package ACWing.数学知识.求组合数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :求组合数 III
 * @Author : LeafTalk
 * @Data : 2022/1/27
 */
public class Demo03 {

    public static long qmi(long a,int b,int p){
        long res =1;
        while(b>0){
            if((b&1)==1){
                res = (res*a)%p;
            }
            a = (a*a)%p;
            b= b>>1;
        }
        return res;
    }

    public static long c(long a,long b,int p){
        if(a<b){
            return 0;
        }
        long res =1;
        for(long i=1,j=a;i<=b;i++,j--){
            res = (res * j) % p;
            res = (res * qmi(i,p-2,p)) %p;
        }
        return res;
    }

    public static long lucas(long a,long b,int p){
        if(a<p && b<p){
            return c(a,b,p);
        }else{
            return (c(a%p,b%p, p) * lucas(a/p,b/p,p)) % p;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String[] arr = br.readLine().split(" ");
            long a = Long.parseLong(arr[0]);
            long b = Long.parseLong(arr[1]);
            int p = Integer.parseInt(arr[2]);
            System.out.println(lucas(a,b,p));
        }
    }
}
