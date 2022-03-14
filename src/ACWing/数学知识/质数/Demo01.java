package ACWing.数学知识.质数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 试除法判断判断质数
 * @Author : LeafTalk
 * @Data : 2021/12/21
 */
public class Demo01 {

    //暴力求解 O(n)
    public static boolean isPrime01(int n){
        if(n<2){
            return false;
        }
            for(int i=2;i<n;i++){
                if(n % i == 0){
                    return false;
                }
            }
            return true;
    }


    //根据 质数因子都是成对出现 i和 n/i ，i <= n/i => i*i <= n => i <= √n 可以将效率调高到 O(√n)
    public static boolean isPrime02(int n){
        if(n<2){
            return false;
        }
        //此处可以有写法 1. i< sqrt(n)，开根号操作比较耗时，不推荐 2. i * i < n,有整数溢出风险，不推荐
        for(int i=2;i< n/i;i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            if(isPrime01(m)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
