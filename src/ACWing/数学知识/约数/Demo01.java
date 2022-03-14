package ACWing.数学知识.约数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description :试除法求约数
 * @Author : LeafTalk
 * @Data : 2021/12/21
 */
public class Demo01 {
    //暴力求解
    public static void getPrime01(int n){
        if(n == 1){
            System.out.print(1);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(n % i == 0){
                System.out.print(i+" ");
            }
        }
    }

    //
    public static void getPrime02(int n){
        List<Integer> list = new ArrayList<Integer>();
        if(n == 1){
            System.out.print(1);
            return;
        }
        for (int i = 1; i <= n/i; i++) {
            if(n % i == 0){
                list.add(i);
                if(n/i != i){
                    list.add(n/i);
                }
            }
        }
        Collections.sort(list);
        list.forEach(i -> {
            System.out.print(i+" ");
        });
    }

    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            getPrime02(m);
            System.out.println();
        }
    }
}
