package ACWing.Tire查找树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :最大异或对
 * @Author : LeafTalk
 * @Data : 2021/10/18
 */
public class Demo28 {
    static int N = 100010,M = 3100010;
    static int[] a = new int[N];
    static int[][] arr = new int[M][2];
    static int idx = 0;

    public static void insert(int x){
        int b = 0;
        for (int i = 30; i >= 0; i--) {
            int f = (x >> i) & 1;
            int s = arr[b][f];
            if(s== 0){
                arr[b][f] = ++idx;
            }
            b =arr[b][f];
        }
    }

    public static int query(int x){
        int b =0,res=0;
        for(int i=30;i >=0;i--){
            int s = (x >> i) & 1;
            int s2 = 1 - s;
            int f = arr[b][s2];
            if(f !=0 ){
                res += 1 << i;
                b = arr[b][s2];
            }else{
                b = arr[b][s];
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        String[] str = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(str[i]);
            insert(a[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res,query(a[i]));
        }
        System.out.println(res);

    }
}
