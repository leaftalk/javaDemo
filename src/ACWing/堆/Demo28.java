package 堆;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :堆（一维数组模拟）
 * @Author : LeafTalk
 * @Data : 2021/10/18
 */
public class Demo28 {
    static int N = 100010;
    static int[] h = new int[N];

    public static void down(int k,int size){
        int f = k;
        int left = k*2;
        int right = k*2+1;
        if(left<=size && h[left]< h[k]){
            f = left;
        }
       if(right<=size && h[right] < h[k]){
            f = right;
        }
        if(f != k){
            int a = h[k];
            h[k] = h[f];
            h[f] = a;
            down(f,size);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        String[] str02 = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            h[i] = Integer.parseInt(str02[i-1]);
        }

        for (int i = n/2; i>=1; i--) {
            down(i,n);
        }

        int size = n;
        while(m -- > 0){
            System.out.printf(h[1] + " ");
            h[1] = h[size];
            size--;
            down(1,size);
        }

    }
}
