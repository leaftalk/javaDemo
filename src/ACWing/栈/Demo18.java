package 栈;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Description : 栈 （数组模拟）
 * @Author : LeafTalk
 * @Data : 2021/10/12
 */
public class Demo18 {
    static int N = 100010;
    static int[] stack = new int[N];
    static int tt = 0;

    //入栈
    public static void push(int x){
        stack[++tt] = x;
    }

    //出栈
    public static void pop(){
        if(tt>0){
            --tt;
        }
    }

    public static String empty(){
            if(tt>0){
                return "no";
            }else{
                return "yes";
            }
    }

    public static int query(){
            return stack[tt];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();

        while(m-->0){
            String op = in.next();
            switch (op){
                case "push": push(in.nextInt());
                break;
                case "pop": pop();
                    break;
                case "empty":
                    System.out.println(empty());
                    break;
                case "query":
                    System.out.println(query());
                    break;
            }
        }
        in.close();
    }
}
