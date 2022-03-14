package ACWing.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :KMP 字符串模式匹配
 * @Author : LeafTalk
 * @Data : 2021/10/9
 */
public class Demo15 {
    static int N = 100010;
    static char[] p = new char[N];
    static char[] s = new char[N];
    static int[] next = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //匹配串
        String str = br.readLine().toString();
        p = str.toCharArray();

        //模式串
        int m = Integer.parseInt(br.readLine());
        String str02 = br.readLine().toString();
        s = str02.toCharArray();

        //计算next数组
        next[0] = -1;
        for(int i=1,j=-1;i<n;i++){
            while(j!=-1 && p[i] != p[j+1]){
                j= next[j];
            }
            if(p[i] == p[j+1]){
                j++;
            }
            next[i] = j;
        }

        //主串与模式串 匹配
        for(int i=0,j=-1;i<m;i++){
            while(j!=-1 && s[i]!=p[j+1]){
                j=next[j];
            }
            if(s[i] == p[j+1]) {
                j++;
            }

            if(j == n-1){
                System.out.println(i-n+1 + " "+ i);
                j = next[j];
            }
        }

    }
}
