package ACWing.动态规划.状态压缩DP.蒙德里安的猜想;

import java.util.Scanner;

/**
 * @Description : 蒙德里安的梦想
 *核心：先放横着的，再放竖着的；一旦横着的放好，竖着的只有一种方案
 * 状态表示： f[i,j]： 已经将前i-1列的方摆好，从i-1列伸出到第i列的所有方案
 * @Author : LeafTalk
 * @Data : 2022/3/11
 */
public class Demo01 {
    static int N = 12;
    static int M = 1<<12;
    static long[][] f =new long[N][M];
    static boolean[] st =new boolean[M];//存储 对于每列所有分布情况中能成功转移的情况(排除了连续为0的个数为奇数的情况，只有连续为0的个数为偶数是才能插入竖向的长方形)

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n,m;
        while(true){
            n = sc.nextInt();
            m = sc.nextInt();

            if((n|m)==0){
                break;
            }

            //初始化
            for (int i = 0; i < N; i++) {
                for (int i1 = 0; i1 < M; i1++) {
                    f[i][i1] =0;
                }
            }

            //先预处理从n行的所有情况下
            //从0开始按位枚举到第n行(0000,0001,0010,0011....1111)
            for(int i=0;i< 1<<n;i++){
                st[i] =true;
                int cnt=0;
                //枚举每个xxxx的每一位
                for(int j=0;i<n;j++){
                    //如果第j位是1,则判断之前累计的0是否为偶数个
                    if((i>>j&1) !=0){
                        //如果之前0位的个数是奇数个，则不能插入竖着的小方块，不合法
                        if((cnt &1)!=0){
                            st[i] =false;
                            break;
                        }
                        cnt = 0; //清空计数
                    }else{
                        //如果xxxx第j位是0,则cnt加一
                        cnt++;
                    }
                }
                if((cnt &1) !=0 ) st[i] =false;
            }

            f[0][0] = 1;

            for(int i=1;i<=m;i++){ //枚举每一列
                for(int j=0;j< 1<<n;j++){ //从0000按位枚举到n
                    for(int k=0;k< 1<<n;k++){ //枚举前一列的所有状态
                        if((j&k)==0 && st[j|k]){ //
                            f[i][j] += f[i-1][k];
                        }
                    }
                }
            }
            System.out.println(f[m][0]); //m-1列已经摆好，从m-1列伸到m列的方案为0
        }
    }
}
