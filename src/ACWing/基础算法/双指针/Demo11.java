package ACWing.基础算法.双指针;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 最长连续不重复子序列
 * @Author : LeafTalk
 * @Data : 2021/10/3
 */
public class Demo11 {
    static int N = 10010;
    static int[] arr = new int[N];
    static int[] s = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] str = bf.readLine().split(" ");

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        int res = 0;
        for(int i=0,j=0;i<n;i++){
            s[arr[i]] ++;
            while(s[arr[i]] >1){
                s[arr[j]]--;
                j++;
            }
            res = Math.max(res,i-j+1);
        }

    }
}
