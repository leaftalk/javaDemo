package 搜索与图论.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 走迷宫
 * @Author : LeafTalk
 * @Data : 2021/11/24
 */
public class Demo01 {
    static int N = 110;
    static int n ;
    static int m ;
    static int[][] arr = new int[N][N]; //
    static int[][] d = new int[N][N]; // 存储距离
    static PII[] queue = new PII[N*N];

    public static void bfs(){
        int hh = 0,tt=0;
        queue[0] = new PII(0,0);
        int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                    d[i][j] = -1;
            }
        }
        d[0][0] = 0;

            while(hh<=tt){
                PII a = queue[hh++];
                for(int i =0;i<4;i++){
                    int x = a.getFirst() +dx[i], y = a.getSecond() +dy[i];
                    if(x>=0 && x<n && y>=0 && y<m && arr[x][y] ==0 && d[x][y] ==-1){
                        d[x][y] = d[a.getFirst()][a.getSecond()] +1;
                        queue[++tt] = new PII(x,y);
                    }
                }
            }
        System.out.println(d[n-1][m-1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       String[] str = bf.readLine().split(" ");
       n = Integer.parseInt(str[0]);
       m = Integer.parseInt(str[1]);
        for (int i = 0; i < n; i++) {
            String[] str02 = bf.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(str02[j]);
            }
        }
        bfs();
    }
}
class PII {
    private int first;
    private int second;

    public PII(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
