package 并查集;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :连通块中点的数量
 * @Author : LeafTalk
 * @Data : 2021/10/18
 */
public class Demo26 {
    static int N = 100010;
    static int[] arr = new int[N];
    static int[] cnt = new int[N];

    public static int find(int x){
        if(arr[x] != x){
            arr[x] = find(arr[x]);
        }
        return arr[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
            cnt[i] = 1;
        }

        while(m-->0){
            String[] str02 = bf.readLine().split(" ");
            String op = str02[0];
            switch(op){
                case "C":
                    //此处要先find
                    int a = find(Integer.parseInt(str02[1]));
                    int b = find(Integer.parseInt(str02[2]));
                    //a,b不在一个集合中
                    if(a != b){
                        arr[a] = b;
                        cnt[b] += cnt[a];
                    }
                    break;
                case "Q1":
                    int c = Integer.parseInt(str02[1]);
                    int d = Integer.parseInt(str02[2]);
                    if(find(c) == find(d)){
                        System.out.println("Yes");
                    }else{
                        System.out.println("No");
                    }
                    break;
                case "Q2":
                    int e = Integer.parseInt(str02[1]);
                    System.out.println(cnt[find(e)]);
                    break;
            }
        }
    }
}
