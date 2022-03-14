package ACWing.哈希表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 字符串哈希
 * @Author : LeafTalk
 * @Data : 2021/11/1
 */
public class Demo03 {
    static int N = 100010,b = 131;
    static char[] arr = new char[N];
    static long[] p = new long[N];//存储字符串前缀和
    static long[] h = new long[N];//存储 各位权重

    public static long get(int l,int r){
        return p[r] - p[l-1] * h[r-l+1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        arr = bf.readLine().toCharArray();

        h[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = (p[i-1] * b + ( arr[i-1] - 'a')) % Long.MAX_VALUE;
            h[i] = h[i-1] * b;
        }
        while(m-->0){
            String[] str02 = bf.readLine().split(" ");
            int l1 = Integer.parseInt(str02[0]);
            int r1 = Integer.parseInt(str02[1]);
            int l2 = Integer.parseInt(str02[2]);
            int r2 = Integer.parseInt(str02[3]);
            if(get(l1,r1) == get(l2,r2)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
