package ACWing.队列;

import java.io.*;

/**
 * @Description : 滑动窗口 （单调对列）
 *
 *解决滑动窗口问题
 *
 * @Author : LeafTalk
 * @Data : 2021/10/12
 */
public class Demo21 {
    static int N = 1000010;
    static int[] arr = new int[N];
    static int[] queue = new int[N];
    static int hh=0,tt=-1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str01 = bf.readLine().split(" ");
        int m = Integer.parseInt(str01[0]);
        int k = Integer.parseInt(str01[1]);

        String[] str02 = bf.readLine().split(" ");
        for (int i=0;i<m;i++){
            arr[i] = Integer.parseInt(str02[i]);
        }

        for(int i=0;i<m;i++){
            //去除 多余i-k=1的部分
            while(hh<= tt && arr[queue[tt]] >= arr[i]){
                tt--;
            }
            //队列递增存储，从队尾开始去除不满足的数
            if(hh<=tt && queue[hh] < i-k+1) {
                hh++;
            }
            //新数入队
            queue[++tt] =i;

            if(i>=k-1){
                bw.write(arr[queue[hh]] + " ");
            }

        }
        bw.write("\n");
        hh =0;
        tt=-1;
        for(int i=0;i<m;i++){
            while(hh<= tt && arr[queue[tt]] <= arr[i]){
                tt--;
            }
            if(hh<=tt && queue[hh] < i-k+1) {
                hh++;
            }
            queue[++tt] =i;

            if(i>=k-1){
                bw.write(arr[queue[hh]] + " ");
            }

        }
        bw.flush();

    }
}
