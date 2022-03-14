package ACWing.栈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 单调栈
 *
 *  解决NGE问题（Next Greater Element）
 * 求 下一个或者上一个 元素 比本身大或者小问题
 *
 * @Author : LeafTalk
 * @Data : 2021/10/12
 */
public class Demo20 {
    static int N = 100010;
    static int[] stack = new int[N];
    static int hh=0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());

        String[] str = bf.readLine().split(" ");
        for(int i=0;i<m;i++){
            int n = Integer.parseInt(str[i]);

            while(hh>0 && stack[hh]>=n){
                hh--;
            }
            if(hh==0) {
                System.out.printf("-1" + " ");
            }else{
                System.out.printf(stack[hh] + " ");
            }
            stack[++hh] = n;
        }
    }
}
