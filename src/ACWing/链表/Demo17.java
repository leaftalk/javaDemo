package 链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :双链表 （数组模拟）
 * @Author : LeafTalk
 * @Data : 2021/10/11
 */
public class Demo17 {
    static int N = 100010;
    static int[] e = new int[N];
    static int[] l = new int[N];
    static int[] r = new int[N];
    static int idx = 0;

    //插入
    public static void insertK(int k,int x){
        e[idx] =x;
        r[idx] = r[k];
        l[r[k]] = idx;
        l[idx] = k;
        r[k] = idx;
        idx++;
    }

    //删除第k个插入的数
    public static void delete(int k){
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());

        //0是左侧端点
        r[0] = 1;
        //1是右侧端点
        l[1] = 0;
        idx= 2;

        while(m-->0){
           String[] str =  bf.readLine().split(" ");
           switch(str[0]){
               //最左端插入
               case "L":
                    insertK(0,Integer.parseInt(str[1]));
                   break;

               //最右端插入
               case "R":
                   insertK(l[1],Integer.parseInt(str[1]));
                   break;

               //删除
               case "D":
                   delete(Integer.parseInt(str[1])+1);
                   break;

               //在第k个数左侧插入
               case "IL":
                   //在第k个左侧插入，先找到l[k]，再在l[k]右侧插入
                   insertK(l[Integer.parseInt(str[1])+1],Integer.parseInt(str[2]));
                   break;

               //在第k个数右侧插入
               case "IR":
                   insertK(Integer.parseInt(str[1])+1,Integer.parseInt(str[2]));
                   break;
           }
        }
        for(int i =r[0]; i !=1;i=r[i]){
            System.out.printf(e[i]+ " ");
        }
    }
}
