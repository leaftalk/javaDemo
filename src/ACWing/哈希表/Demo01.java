package ACWing.哈希表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :散列表 （拉链法）
 * @Author : LeafTalk
 * @Data : 2021/10/22
 */
public class Demo01 {
        static int N = 100003;
        static int[] p = new int[N];
        static int[] e = new int[N];
        static int[] ne = new int[N];
        static int idx = 0;

   public static void insert(int x){
       int k = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = p[k];
        p[k] = idx;
        idx++;
   }

   public static Boolean find(int x){
       int k = (x % N + N) % N;
       for(int i=p[k];i!=-1;i=ne[i]){
           if(x == e[i]){
               return true;
           }
       }
       return false;
   }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            p[i] = -1;
        }
        while(n-->0){
            String[] str = bf.readLine().split(" ");
            String op = str[0];
            int a = Integer.parseInt(str[1]);
            if(op.equals("I")){
                insert(a);
            }else{
                if(find(a)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
    }
}
