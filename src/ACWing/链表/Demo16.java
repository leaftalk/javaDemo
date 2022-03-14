package 链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 单链表(用数组模拟单链表)
 * @Author : LeafTalk
 * @Data : 2021/10/9
 */
public class Demo16 {
    static int N = 100010;
    static int[] val = new int[N];
    static int[] next = new int[N];
    static int idx;
    static int head;

    //数组初始化
    public static void init(){
        head=-1;
        idx=0;
    }

    //在第k个数后插入
    public static void insert(int k,int x){
        val[idx] = x;
        next[idx] = next[k];
        next[k] =idx;
        idx++;
    }

    //向链表头插入一个数
    public static void insert(int x){
        val[idx] = x;
        next[idx] = head;
        head = idx;
        idx++;
    }

    //删除第k个插入的数的后面的数
    public static void remove(int k){
        next[k] = next[next[k]];
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());
        //初始化
        init();
        while(m-->0) {
            String[] str = bf.readLine().split(" ");
            if(str[0].equals("H")){
                insert(Integer.parseInt(str[1]));
            }else if(str[0].equals("D")){
                int x = Integer.parseInt(str[1]);
                if(x ==0 ){
                    //删除头结点
                    head = next[head];
                }else{
                    remove(x-1);
                }

            }else if(str[0].equals("I")){
                insert(Integer.parseInt(str[1])-1,Integer.parseInt(str[2]));
            }
        }
        int x = head;
        while(x != -1){
            System.out.print(val[x] + " ");
            x=next[x];
        }

    }
}
