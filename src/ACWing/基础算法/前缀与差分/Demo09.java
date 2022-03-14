package ACWing.基础算法.前缀与差分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :差分(对(l,r)区间内的数加上c)
 * @Author : LeafTalk
 * @Data : 2021/10/2
 */
public class Demo09 {
    static int N = 100010;
    static int[] a = new int[N];
    static int[] b = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int l = Integer.parseInt(str[0]);
        int r = Integer.parseInt(str[1]);

        String[] str02 = bf.readLine().split(" ");
        for(int i=1;i<=l;i++){
            a[i] = Integer.parseInt(str02[i-1]);
        }

        for(int i=1;i<=l;i++){
            add(i,i,a[i]);
        }

        while(r-->0){
            String[] str03 = bf.readLine().split(" ");
            int x1 = Integer.parseInt(str03[0]);
            int x2 = Integer.parseInt(str03[1]);
            int x3 = Integer.parseInt(str03[2]);
            add(x1,x2,x3);
        }

        for(int i=1;i<=l;i++){
            b[i] += b[i-1];
            System.out.printf(b[i]+" ");
        }
    }

    public static void add(int l,int r,int x){
        b[l] += x;
        b[r+1] -= x;
    }
}
