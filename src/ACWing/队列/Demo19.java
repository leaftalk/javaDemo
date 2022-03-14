package ACWing.队列;

import java.util.Scanner;

/**
 * @Description : 数组模拟队列
 * @Author : LeafTalk
 * @Data : 2021/10/12
 */
public class Demo19 {
    static int N = 100010;
    static int queue[] = new int[N];
    static int tt=-1, hh=0;

    public static void push(int x){
        queue[++tt] = x;
    }

    public static void pop (){
        hh++;
    }

    public static String empty(){
        if(tt>=hh){
            return "NO";
        }else{
            return "YES";
        }
    }

    public static int query(){
        return queue[hh];
    }

    public static void main(String[] args) {
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
