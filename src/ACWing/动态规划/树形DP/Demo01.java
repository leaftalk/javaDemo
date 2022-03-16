package ACWing.动态规划.树形DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description : 没有上司的舞会
 * 状态表示：  集合： f[i,0]: 第i个人来，其下属所能获取的最大快乐总数；f[i,1]: 第i个人不来，其下属所能获取的最大快乐总数
 *           属性：max
 * 状态计算：  f[i,0] = ∑ max(f[si,1],f[si,0])(将i的所有子树si的最大值相加), f[i,1] = ∑f[si,0]
 * @Author : LeafTalk
 * @Data : 2022/3/15
 */
public class Demo01 {
    static int N =  6010;
    static int n;
    static int[] happy = new int[N];
    static int idx = 0;//计数
    static int[] e = new int[N];//存储idx个插入的值
    static int[] h = new int[N];
    static int[] ne = new int[N]; //存储子树结点
    static boolean[] has_bef = new boolean[N]; //是否有上司
    static int[][] f = new int[N][2];

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            happy[i] = sc.nextInt();
        }
        //初始化
        Arrays.fill(h,-1);

        //存储树
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();//下属
            int b = sc.nextInt();//上司
            add(a,b);
            has_bef[a]=true;
        }

        //找根结点
        int root = 1;
        while(has_bef[root]){
            root++;
        }
        dfs(root);

        System.out.println(Math.max(f[root][1],f[root][0]));
    }

    public static void add(int a,int b){
            e[idx] = a;
            ne[idx] = h[b];
            h[b] = idx++;
    }

    public static void dfs(int root){
        f[root][1] = happy[root];

        for(int i=h[root];i!=-1;i=ne[i]){
            int j=e[i]; //结点值
            dfs(j);

            f[root][0] += Math.max(f[j][0],f[j][1]);
            f[root][1] += f[j][0];
        }
    }
}
