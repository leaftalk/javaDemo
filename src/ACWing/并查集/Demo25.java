package 并查集;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 并查集优化 (数组模拟)
 * @Author : LeafTalk
 * @Data : 2021/10/15
 */
public class Demo25 {
    static int N = 100010;
    //用于存储 当前节点的父节点
    static int[] arr = new int[N];
    //用于记录并查集的深度
    static int[] rank = new int[N];

    //查找x的根节点，并且 压缩路径
    public static int  query (int x){
        if(arr[x] != x){
            arr[x] = query(arr[x]);
        }
        return arr[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        //初始化，每个元素都一个集合中
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
            rank[i] = 1;
        }

        while(m-->0){
            String[] str02 = bf.readLine().split(" ");
            String op = str02[0];
            switch (op){
                //合并集合
                case "M":
                    int aa = query(Integer.parseInt(str02[1]));
                    int bb = query(Integer.parseInt(str02[2]));
                    //a集合的深度比b深，则b集合合进a集合
                    if(rank[aa] >= rank[bb]){
                        arr[bb] =aa;
                    }else{
                        arr[aa] = bb;
                    }
                    //如果两个集合深度一样，但是根节点不一样，则bb合进aa集合的时候，aa集合深度要加1
                    if(rank[aa] == rank[bb] && aa != bb){
                        rank[aa]++;
                    }
                    break;
                //查询两个元素是否在一个集合中
                case "Q":
                    int a =query(Integer.parseInt(str02[1]));
                    int b =query(Integer.parseInt(str02[2]));
                    if(a == b ){
                        System.out.println("Yes");
                    }else{
                        System.out.println("No");
                    }
                    break;
            }
        }
    }
}
