package 并查集;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 并查集 (数组模拟)
 * @Author : LeafTalk
 * @Data : 2021/10/15
 */
public class Demo24 {
    static int N = 100010;
    //用于存储 当前节点的父节点
    static int[] arr = new int[N];

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
        }

        while(m-->0){
            String[] str02 = bf.readLine().split(" ");
            String op = str02[0];
            switch (op){
                //合并集合
                case "M":
                    int aa = Integer.parseInt(str02[1]);
                    int bb = Integer.parseInt(str02[2]);
                        arr[query(aa)] = query(bb);
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
