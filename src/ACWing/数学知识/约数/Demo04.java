package ACWing.数学知识.约数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :最大公约数
 * @Author : LeafTalk
 * @Data : 2021/12/27
 */
public class Demo04 {

    //欧几里得算法(辗转相除法)： gcd(a,b) = gcd(b,a%b) => a和b的最大公约数=b 和 a%b 的最大公约数
    //两个整数的最大公约数等于其中较小的那个数和两数相除余数的最大公约数
    //a = k1b +r, d为a和b的最大公约数，则a，b都可以整除d，r=a - k1b=k2b+a, r/d = a/d（整数） - kb/d（整数）也是整数，所以 d也是 a%b=r 的公约数
    //所以 a,b的公约数 与 b和a%b的公约数相同，则最大公约数也相同
    //注： 传入参数（a,b）当 a<b时, a%b = a => 进过一遍递归参数又变成（b，a）
    public static int getMaxDivisor(int a,int b){

        return b != 0 ? getMaxDivisor(b,a%b ) : a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = getMaxDivisor(a, b);
            System.out.println(c);
        }
    }
}
