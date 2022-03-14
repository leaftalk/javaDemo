package 搜索与图论.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :n-皇后问题( 按行枚举 )     时间复杂度：O(n!)
 * @Author : LeafTalk
 * @Data : 2021/11/4
 */
public class Demo03 {
    static int N = 20;
    static int n;
    static char[][] arr = new char[N][N];
    static boolean[] col = new boolean[N];
    static boolean[] dg = new boolean[N];// 记录正对角线 (按截距记录)
    static boolean[] edg = new boolean[N];// 记录反对角线 (按截距记录)

    public static void dfs(int m) {
        if (m == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[i + m] && !edg[n - m + i]) {
                arr[m][i] = 'Q';
                col[i] = dg[m + i] = edg[n + i - m] = true;
                dfs(m + 1);
                col[i] = dg[m + i] = edg[n + i - m] = false;
                arr[m][i] = '.';
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = '.';
            }
        }
        dfs(0);

    }
}
