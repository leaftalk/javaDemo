package 搜索与图论.拓补序列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :
 * @Author : LeafTalk
 * @Data : 2021/12/2
 */
public class Demo01 {
    static int N =100010;
    static int n,m;
    static int idx =1;
    static int[] e = new int[N];
    static int[] ne =new int[N];
    static int[] h = new int[N];
    static int[] d = new int[N]; //记录每个点的入度
    static int[] queue = new int[N];//记录入度为0的点

    public static void add(int a,int b){
            e[idx] =b;
            ne[idx] = h[a];
            h[a] = idx++;
    }

    public static boolean topsort(){
        int hh=0,rr=-1;
        for (int i = 1; i <= n; i++) {
            if(d[i] == 0){
                queue[++rr] = i;
            }
        }
        while(hh<=rr){
            int t = queue[hh++];
            for(int i =h[t];i!=0;i=ne[i]){
                int x =e[i];
                if(--d[x]==0){
                    //入度为0的点，入队
                    queue[++rr] = x;
                }
            }
        }
        return rr == n-1;
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
            d[b]++;
        }
        if(topsort()){
            for (int i = 0; i < n; i++) {
                System.out.print(queue[i]+ " ");
            }
        }else{
            System.out.println("-1");
        }

    }
}
