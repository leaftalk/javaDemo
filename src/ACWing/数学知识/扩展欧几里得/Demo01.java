package ACWing.数学知识.扩展欧几里得;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :扩展欧几里得算法
 * @Author : LeafTalk
 * @Data : 2022/1/4
 */
public class Demo01 {
    static int x;
    static int y;

    //裴蜀定理：ax + by = gcd(a,b)  对于任意a,b 一定存在整数 x, y 使得 ax+by = a,b最大公约数
//    当 b=0 时 ax+by=a 故而 x=1,y=0
//    当 b≠0时
//    因为
//              gcd(a,b)=gcd(b,a%b)
//    而
//              bx′+(a%b)y′=gcd(b,a%b)
//          bx′+(a−⌊a/b⌋∗b)y′=gcd(b,a%b)
//      ay′+b(x′−⌊a/b⌋∗y′)=gcd(b,a%b)=gcd(a,b)
//    故而
//            x=y′,y=x′−⌊a/b⌋∗y′
//    因此可以采取递归算法 先求出下一层的x′x′和y′y′ 再利用上述公式回代即可

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

    public static int exgcd02(int a,int b,int x1,int y1){
        if(b == 0){
            x1=1;
            y1=0;
            return a;
        }
        int gcd =  exgcd02(b, a%b,y1,x1 );
        y1 -= (a /b) * x1;
        return gcd;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String[] str = br.readLine().split(" ");
            int a =0;
            int b =0;
            exgcd02(Integer.parseInt(str[0]),Integer.parseInt(str[1]),a,b);
            System.out.println(x + " "+ y);
            x = 0;
            y=0;
        }
    }
}
