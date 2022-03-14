package ACWing.哈希表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :散列表 （开放地址法）
 * @Author : LeafTalk
 * @Data : 2021/10/22
 */
public class Demo02 {
    static int N = 200003;
    static int[] p = new int[N];
    static int min = 0x3f3f3f3f;

    public static int find(int x){
        int k = (x % N + N ) % N;
        while( p[k]!= min && p[k] != x){
            k++;
            if(k==N){
                k=0;
            }
        }
        return k;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            p[i] = min;
        }
        while(n-->0){
            String[] str = bf.readLine().split(" ");
            String op = str[0];
            int a = Integer.parseInt(str[1]);
            if(op.equals("I")){
                    p[find(a)] = a;
            }else{
                if(find(a) == 0){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
    }
}
