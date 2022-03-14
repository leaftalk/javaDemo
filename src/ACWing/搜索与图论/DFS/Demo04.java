package 搜索与图论.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :n-皇后问题( 按行枚举 )     时间复杂度：O(2^n²)
 * @Author : LeafTalk
 * @Data : 2021/11/4
 */
public class Demo04 {
    static int N = 10;
    static int n;
    static char[][] arr = new char[N][N]; //
    static boolean[] row = new boolean[N]; // 记录行
    static boolean[] col = new boolean[N];// 记录列
    static boolean[] dg = new boolean[N*2];// 记录正对角线 (按截距记录)
    static boolean[] udg = new boolean[N*2];// 记录反对角线(按截距记录)

    public static void dfs(int x,int y,int count) {
        if(count > n) return;
        if(y == n) {
            x++;
            y=0;
        }
        if(x == n){
            if(count == n){
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(arr[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
            }
            return;
        }
        arr[x][y] = '.';

        if(!row[x] && !col[y] && !dg[x+y] && !udg[x-y+n]){
            arr[x][y] = 'Q';
            row[x] = col[y] = dg[x+y] = udg[x-y+n] = true;
            dfs(x,y+1,count+1);
            //恢复现场
            arr[x][y] = '.';
            row[x] = col[y] = dg[x+y] = udg[x-y+n] = false;
        }
        dfs(x,y+1,count);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        dfs(0,0,0);

    }
}
