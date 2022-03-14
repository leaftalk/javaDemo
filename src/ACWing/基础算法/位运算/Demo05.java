package ACWing.基础算法.位运算;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :求二进制中1的个数
 * @Author : LeafTalk
 * @Data : 2021/9/28
 */
public class Demo05 {
    static int N = 10010;
    static int[] arr = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] str = bf.readLine().split(" ");
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(str[i]);

        for(int j=0;j<n;j++){
            int i = arr[j];
            int res =0;
            while(i>0) {
                i -= i & -i;
                res++;
            }
            System.out.printf(res+" ");
        }
    }
}
