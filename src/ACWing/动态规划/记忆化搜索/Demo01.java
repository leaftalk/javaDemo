package ACWing.动态规划.记忆化搜索;

import java.util.Scanner;

/**
 * @Description :滑雪
 * 状态表示： 集合： f[i,j]: 从i,j开始滑的路径
 *          属性：最大值
 * 状态计算： f[i,j] = max(f[i-1,j],f[i,j-1],f[i+1,j],f[i,j+1])+1, 从i,j向上下左右移动，取其中的最大值
 *
 * @Author : LeafTalk
 * @Data : 2022/3/14
 */
public class Demo01 {
    static int N = 310;
    static int n;
    static int m;
    static int[][] d = new int[N][N];
    static int[][] f = new int[N][N];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                d[i][j] = sc.nextInt();
                f[i][j] = -1;
            }
        }

        int res=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                res = Math.max(res,dp(i,j));
            }
        }

        System.out.println(res);
    }

    static int dp(int a,int b){
        if(f[a][b]!=-1) return f[a][b];

        f[a][b] = 1;
        for(int i=0;i<4;i++){
            int x = a+dx[i];
            int y = b+dy[i];
            if(x>=1 && x<= n && y>=1 && y<=m && d[x][y]<d[a][b] ){
                f[a][b] =Math.max(f[a][b],dp(x,y)+1);
            }
        }

        return f[a][b];
    }
}
