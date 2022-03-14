package ACWing.Tire查找树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :tire查找树(字符串搜索)
 * @Author : LeafTalk
 * @Data : 2021/10/15
 */
public class Demo23 {
    static int N = 100010;
    static int[] str = new int[N];
    //用于存储下一个字母下标
    static int[][] son = new int[N][26];
    //用于标记字符串的结尾
    static int[] cnt = new int[N];
    static int idx;

    public static void insert(char[] chars){
        int p =0;
        for (int i = 0; i < chars.length; i++) {
            int a = chars[i] - 'a';
            if(son[p][a] == 0){
                son[p][a] = ++idx;
            }
            p=son[p][a];
        }
        cnt[p]++;
    }

    public static int query(char[] chars){
            int p =0;
        for (int i = 0; i < chars.length; i++) {
            int a = chars[i] - 'a';
            if(son[p][a] ==0){
                return 0;
            }
            p =son[p][a];
        }
        return cnt[p];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());

        while(m-- >0){
            String[] str =  bf.readLine().split(" ");
            String op = str[0];
            switch (op){
                case "I":
                    insert(str[1].toCharArray());
                    break;
                case "Q":
                    System.out.println(query(str[1].toCharArray()));
                    break;
            }
        }
    }
}
