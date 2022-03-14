package 搜索与图论.树与图的广度优先遍历;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @Description :图中点的层次
 * @Author : LeafTalk
 * @Data : 2021/12/1
 */
public class Demo01 {
    static int N = 100010;
    static int n,m;
    static int idx=1;
    static int[] e= new int[N];
    static int[] ne= new int[N];
    static int[] h = new int[N];
    static int[] queue = new int[N];
    static int[] d = new int[N];//存储1号点到其他每个点的最短距离

    //图的散列表存储法
    public static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static int bfs(){
        int hh =0,rr=0;//对头，队尾
        queue[rr++] = 1;//1号点入队
        //初始化
        for (int i = 1; i <= n; i++) {
            d[i] = -1;
        }
        d[1] = 0;
        while(hh<rr){
            int t = queue[hh++];
            for(int i = h[t];i!=0;i=ne[i]){
                int b = e[i];
                if(d[b] == -1){
                    d[b] = d[t] +1;
                    queue[rr++] =b;
                }
            }
        }
        return d[n];
    }

    public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String[] str = bf.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);

        for (int i = 0; i < m; i++) {
            String[] str02 = bf.readLine().split(" ");
            int a = Integer.parseInt(str02[0]);
            int b = Integer.parseInt(str02[1]);
                add(a,b);
        }

        System.out.println(bfs());

    }
}
