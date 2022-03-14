package ACWing.数学知识.质数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 筛质数
 * @Author : LeafTalk
 * @Data : 2021/12/23
 */
public class Demo03 {
    static int N =1000010;
    static int cnt;
    static int[] Prime = new int[N];
    static boolean[] st = new boolean[N]; //判断每个数是否为素数

    //朴素筛法
    //时间复杂度： 每个数被循环 n/i次，n个数一共循环 （n/1 + n/2 + n/3 ......+ n/n）= n(1+ 1/2 + 1/3 + 1/4 ..... 1/n )调和级数 = n* (ln(n) + C)
    public static void prime(int n){
        //把每个数的倍数筛掉，剩下的都是质数
        for (int i = 2; i <= n; i++) {
                if(!st[i]){
                    Prime[cnt++] = i;
                }

            for(int j= i + i ;j<=n;j += i){
                st[j] = true;
            }
        }
    }

    //朴素筛法优化版： 埃式筛法
    //存在重复筛选问题，比如6，会在i=2是筛除一遍，i=3时筛除一遍
    //只筛除质数的倍数，剩下没被筛掉的都是质数,把所有合数通过他们的质因子筛掉
    //质数定理： 1到n中 只有 n/ln(n)个质数
    //时间复杂度：在朴素筛法的基础上只循环了其中的质数，本来要算n个数，现在要算n/ln(n)个数，为原来的1/ln(n)倍，为  n*ln(n)/ln(n) = n,
    // 真实的时间复杂度在 nlog(log(n)) 到 n 之间
    public static void prime01(int n){
        for (int i = 2; i <= n; i++) {
            if(!st[i]){
                Prime[cnt++] = i;
                for(int j= i + i ;j<=n;j += i){
                    st[j] = true;
                }
            }

        }
    }

    //线性筛法: 用每个合数的最小质因子筛除
    //每个合数x，prime[j]是x的最小质因子，i在枚举到x之前，一定会先枚举到x/prime[j]
    //每个合数只存在一个最小质因子，所有每个数只会被筛一次，所以是线性筛法
    public static void prime02(int n){
        for (int i = 2; i <= n; i++) {
            if(!st[i]){
                Prime[cnt++] = i;
            }

            for(int j=0;Prime[j] <= n/i;j++){
                    st[Prime[j] * i] = true;
                    if(i % Prime[j] == 0){
                        //i % Prime[j] == 0时, prime[j]一定是i的最小质因子，prime[j]也一定是 prime[j]* i的最小质因子（i的最小质因子一定也是i*k的最小质因子）
                        //如果此处不break，那么到下一个循环prime[j+1]不是i的最小质因子，那么也不是prime[j+1]*i的最小质因子，(prime[j+1])*i置为true,则会重复操作
                        break;
                    }
    //i % Prime[j] != 0时, prime[j]一定小于i的最小质因子（如果循环到i的最小质因子时，则会break掉，因此此时prim[j]一定小于i的最小质因子），prime[j]一定是 prime[j]* i的最小质因子
    //prime[j] *i 的最小质因子一定是  min{prime[j],i的最小质因子}
    //例：25的最小质因子是5，当枚举到3时，3<5，则3一定是是3*25的最小质因子
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        prime(n);
        System.out.println(cnt);
    }
}
