package ACWing.数学知识.质数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 分解质因数
 * @Author : LeafTalk
 * @Data : 2021/12/22
 */
public class Demo02 {

    //算法理论基础：每个正整数都能够以唯一的方式表示成它的素因数的乘积 36=2^2 * 3^3; 48=2^4 *3.....
    //时间复杂度O(log(n))到O(√n)之间
    public static void prime(int n){
        //n中最多包含一个大于√n的质因子，先处理小于√n的质因子
        //证明： 反证法，假设 有两个质因子 p1,p2大于√n, 那么 n >= p1*p2 > √n * √n =n  ===>  n > n 矛盾
        for(int i=2;i<= n/i;i++){
            //因数
            if(n % i ==0){
                int j = 0;
                while(n % i ==0){
                    j++;
                    n /= i;
                }
                System.out.println(i + " " + j);
            }
        }
        //大于√n的质因子单独处理
        if(n>1){
            System.out.println(n+" "+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            prime(m);
            System.out.println();
        }
        br.close();
    }
}
