package 搜索与图论.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :排列数字(位运算优化)
 * @Author : LeafTalk
 * @Data : 2021/11/4
 */
public class Demo02 {
    static int N = 10;
    static int n ;
    static int[] arr = new int[N];

    public static void dfs(int m,int state){
        if(m == n){
            for (int i = 0; i < n; i++) {
                System.out.println(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if((state >> i & 1) == 0){
                arr[m] = i + 1;
                dfs(m+1,state + (1 << i));

            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        dfs(0,0);

    }
}
