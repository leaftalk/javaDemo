package 搜索与图论.图与树的深度优先遍历;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 树的重心
 * @Author : LeafTalk
 * @Data : 2021/11/25
 */
public class Demo01 {
    static int N=100010;
    static int n;
    static int idx=1;
    static int[] h = new int[N]; //存储
    static int[] ne  = new int[N*2];
    static int[] val = new int[N*2]; //存储第idx插入数的值
    static boolean[] flag = new boolean[N];
    static int ret = 0x3f3f3f3f;
    //散列表存储图
    public static void add(int a,int b){
            val[idx] = b;
            ne[idx] = h[a];
            h[a] = idx++;
    }

    public static int dfs(int m){
        flag[m] = true;
        int sum=1; //记录每个节点子节点的个数
        int size=0; // 记录每个节点 所有子节点中 连通块个数 的最大值

        for(int i=h[m];i!=0;i=ne[i]){
            int j = val[i];
            if(!flag[j]){
                int s = dfs(j);
                size = Math.max(size,s);
                sum += s;
            }
        }

        size = Math.max(size,n-sum);
        ret = Math.min(ret,size);
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n - 1; i++) {
            String[] str = bf.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            add(a,b);
            add(b,a);
        }
        bf.close();
        dfs(1);
        System.out.println(ret);
    }
}
