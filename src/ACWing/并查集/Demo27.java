package 并查集;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :食物链
 * @Author : LeafTalk
 * @Data : 2021/10/20
 */
public class Demo27 {
    static int N = 50010;
    static int[] arr = new int[N];
    static int[] d = new int[N];

    public static int find(int x){
        if(arr[x] != x){
            int a = find(arr[x]);
            d[x] += d[arr[x]];
            arr[x] = a;
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
        }

        int res = 0;
        while(m-->0){
            String[] str02 = bf.readLine().split(" ");
            int op = Integer.parseInt(str02[0]);
            int a = Integer.parseInt(str02[1]);
            int b = Integer.parseInt(str02[2]);
            // a,b 比n大则为假话
            if(a > n || b> n){
                ++res;
            }else{
                int pa = find(a);
                int pb = find(b);
                // a和b是同类
                if(op == 1){
                        if(pa == pb && (d[a]-d[b]) % 3 != 0){
                           ++res;
                        }else if( pa != pb){
                            arr[pa] = pb;
                            d[pa] = d[b] - d[a];
                        }
                }
                //a吃b
                else if(op == 2){
                    if(pa == pb && (d[a]-d[b]-1)%3 != 0){
                        ++ res;
                    }else if(pa != pb){
                        arr[pa] = pb;
                        d[pa] = d[b] - d[a] +1;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
