package ACWing.基础算法.前缀与差分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 前缀和
 * @Author : LeafTalk
 * @Data : 2021/10/2
 */
public class Demo07 {
    static int N = 100010;
    static int[] a = new int[N];
    static int[] s = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        String[] str02 = bf.readLine().split(" ");
        for(int i=1;i<=n;i++){
            a[i] = Integer.parseInt(str02[i-1]);

        }
        for(int i=1;i<=n;i++){
            s[i] = s[i-1] + a[i];
        }

        for(int i =0;i<m;i++){
            String[] str03 = bf.readLine().split(" ");
            int l = Integer.parseInt(str03[0]);
            int r = Integer.parseInt(str03[1]);
            System.out.println( s[r] - s[l-1]);
        }
        bf.close();

    }
}
