package ACWing.基础算法.双指针;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 双指针算法
 * @Description :
 * @Author : LeafTalk
 * @Data : 2021/9/28
 */
public class Demo04 {
     static int N = 100010;
     static int[] q = new int[N];
     static int[] s = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        for(int i=0;i<n;i++) q[i] = Integer.parseInt(str[i]);

        int res = 0;
        for(int i=0,j=0;i<n;i++){
            s[q[i]] ++;
            while(s[q[i]] >1 ){
                s[q[j]] --;
                j++;
            }
            res = Math.max(res,i-j+1);
        }
        System.out.println(res);

    }
}
