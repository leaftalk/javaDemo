package ACWing.动态规划.数位统计DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description :计数问题
 * @Author : LeafTalk
 * @Data : 2022/3/9
 */
public class Demo01 {
    static int N = 100000000;
    static int a; //存小值
    static int b; //存大值

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();

        while(a !=0 && b!=0){
            if(a > b){
                int c = b;
                b = a;
                a = c;
            }
            for(int i=0;i<=9;i++){
                //前缀和思想: 1~b中i的个数 - 1~a-1中i的个数 = a~b中i的个数
                System.out.print(count(b, i) - count(a - 1, i)+ " ");
            }
            System.out.println();
            a = sc.nextInt();
            b = sc.nextInt();
        }
    }

    //求 1~n 中x出现的次数 假设 n = abcdefg
    public static int count(int n,int x){
        if(n==0){
            return 0;
        }
        List<Integer> list = new ArrayList<>(); // [....g,f,e,d,c,b,a]
        while(n>0){
            list.add(n%10);
            n /= 10;
        }
        int len = list.size();

        //统计n上每一位i出现x的个数
        //x不在最高位时，x出现在第4位上  1< oooxppp < abcdfeg
        int res =0;
        //如果x为0，则不能出现在最高位
        for(int i=len-1 -(x==0 ? 1:0);i>=0;i--){
            // 当 0<= ooo <= abc-1 ,0<=ppp<=999时，x出现的个数都是 abc * 1000
            if(i<len-1){
                res += get(list,len-1,i+1) * power10(i);
                if(x==0) {
                    //当某位为0时， 1<= 000 <= abc-1, 个数为 abc-1 * 1000
                    res -= power10(i);
                }
            }

            //当 ooo = abc时
            //如果第四位为x,则次数为 efg
            if(list.get(i) == x){
                res += get(list,i-1,0) + 1;
            }
            //当第四位 大于x, 次数为 1000
            else if(list.get(i) > x){
                res += power10(i);
            }
            //当第四位 小于x, 次数为 0
        }
            return res;
    }

    //返回 10^n
     static int power10(int n){
        int res=1;
        while(n>0){
            res *=10;
            n--;
        }
        return res;
    }

    //获取 l到r位的数值
    static int get(List<Integer> L,int l,int r){
        int res=0;
        for(int i=l;i>=r;i--){
            res =res *10 + L.get(i);
        }
        return res;
    }
}
