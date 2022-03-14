package 堆;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 模拟堆
 * @Author : LeafTalk
 * @Data : 2021/10/20
 */
public class Demo29 {
    static int N = 100010;
    static int[] arr = new int[N];//堆数组
    static int[] ph = new int[N];//pointer heap用来记录 第i个插入的数对应数组中的下标
    static int[] hp = new int[N];//heap pointer 用来记录 堆中第i个数对应第几个插入的
    static int idx=0; //记录插入的第几个数
    static int size =0;//记录数组中还有多少个数

    public static void down(int k){
            int f = k;
            int l = k*2;
            int r = k*2+1;
            if(l <= size && arr[l] < arr[f]){
                f = l;
            }
            if(r <= size && arr[r]< arr[f]){
                f =r;
            }
            if(k!=f){
                heap_swap(k,f);
                down(f);
            }
    }

    public static void up(int k){
        int f = k /2;
        if(f>0 && arr[f]>arr[k]){
            heap_swap(k,f);
            up(f);
        }
    }

    public static void swap(int[] arr,int a,int b){
        int k = arr[a];
        arr[a] =arr[b];
        arr[b] = k;
    }
    public static void heap_swap(int a,int b){
        swap(ph,hp[a],hp[b]);
        swap(hp,a,b);
        swap(arr,a,b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        while(n-->0){
            String[] str = bf.readLine().split(" ");
            String op = str[0];
            int a,b,c=0;
            switch(op){
                //插入
                case "I":
                   a = Integer.parseInt(str[1]);
                    ++size;
                    ++idx;
                    arr[size] = a;
                    ph[idx] = size;
                    hp[size] = idx;
                    up(size);
                    break;
               //输出最小值
                case "PM":
                    System.out.println(arr[1]);
                    break;
                //删除最小值
                case "DM":
                    heap_swap(1,size);
                    size--;
                    down(1);
                    break;
                //删除第k个值
                case "D":
                        a = Integer.parseInt(str[1]);
                        //获取第k个值在堆中的位置
                        b = ph[a];
                        heap_swap(b,size);
                        size--;
                        down(b);
                        up(b);

                    break;
                //修改第k个值
                case "C":
                    a = Integer.parseInt(str[1]);
                    b = Integer.parseInt(str[2]);
                    //获取第k个插入的值在堆中的位置
                    c =ph[a];
                   arr[c] = b;
                   down(c);
                   up(c);
                    break;
            }
        }
    }
}
