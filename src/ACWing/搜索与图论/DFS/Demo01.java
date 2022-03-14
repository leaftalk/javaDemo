package 搜索与图论.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 排列数字
 * @Author : LeafTalk
 * @Data : 2021/11/3
 */
public class Demo01 {
    static int N = 10;
    static int n ;
    static int[] arr = new int[N];
    static boolean[] flag = new boolean[N];

    public static void dfs(int m){
            if(m == n){
                for (int i = 0; i < n; i++) {
                    System.out.println(arr[i]);
                }

            }
        for (int i = 0; i < n; i++) {
            if(!flag[i]){
                arr[m] = i + 1;
                flag[i] = true;
                dfs(m+1);
                flag[i] = false;
            }

        }

    }

    public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(bf.readLine());
                dfs(0);

    }
}
