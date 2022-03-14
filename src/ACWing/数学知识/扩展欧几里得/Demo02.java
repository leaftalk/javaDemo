package ACWing.数学知识.扩展欧几里得;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 线性同余方程
 * 给定 n 组数据 ai,bi,mi，对于每组数求出一个 xi，使其满足 ai×xi≡bi(mod mi)，如果无解则输出 impossible。
 * @Author : LeafTalk
 * @Data : 2022/1/4
 */
public class Demo02 {
    static int x;
    static int y;

    public static int exgcd(int a,int b){
        if(b == 0){
            x=1;
            y=0;
            return a;
        }
        int gcd =  exgcd(b, a%b );
        int c = y;
        int d = x;
        y = d - a/b * c;
        x = c;
        return gcd;
    }

    // (a*x)% m = b  等价于 a*x - m*y = b 转化为 a*x + m*y =b 求 x,y是否有解的问题
    // 根据扩展欧几里得算法  a*x + m*y = gcd(a,m) = d ,
    // 当 b为d的倍数是, b%d = 0,那么 a*x*(b/d) + m*y*(b/d) = d *(b/d) = b , 此时 ax + my = b ,  x,y有解
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String[] str = br.readLine().split(" ");
            int m = Integer.parseInt(str[2]);
            //获取 a,m 的最大公约数
            int d = exgcd(Integer.parseInt(str[0]),m);
            int b = Integer.parseInt(str[1]);
            //如果 d不为b整数倍数，则不存在
            if(b % d !=0){
                System.out.println("impossible");
            }else{
                //如果b/d 为整数，则b一定可以表示为 a,m的倍数之和
                System.out.println(((long)b/d * x)%m);
            }
            x = 0;
            y=0;
        }
    }
}
