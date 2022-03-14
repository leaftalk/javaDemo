package ACWing.基础算法.离散化;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description :区间离散化 区间和
 * @Author : LeafTalk
 * @Data : 2021/10/2
 */
public class Demo06 {
    static int N = 300010;
    static List<PII> add = new ArrayList<>();
    static List<Integer> alls = new ArrayList<>();
    static List<PII> query = new ArrayList<>();
    static int[] a = new int[N];
    static int[] s = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] st = bf.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        for(int i=0;i<n;i++){
            String[] str = bf.readLine().split(" ");
            int x= Integer.parseInt(str[0]);
            int y= Integer.parseInt(str[1]);
            add.add(new PII(x,y));
            alls.add(x);
        }
        for(int j=0;j<m;j++){
            String[] str = bf.readLine().split(" ");
            int x= Integer.parseInt(str[0]);
            int y= Integer.parseInt(str[1]);
            query.add(new PII(x,y));
            alls.add(x);
            alls.add(y);
        }
        //排序
       Collections.sort(alls);
        //去重
       int sub =  unique(alls);
       alls = alls.subList(0,sub);
       //
        for(PII p : add){
            int f = p.getFirst();
            int s = p.getSecond();
            int c= query(alls,f);
            a[c] += s;
        }

        //前缀求和
        for(int i=1;i<=alls.size();i++){
            s[i] = s[i-1] + a[i];
        }

        for(PII p:query){
            int l = query(alls,p.getFirst());
            int r = query(alls,p.getSecond());
            System.out.println(s[r] - s[l-1]);
        }

    }

    //list去重
    public static int unique(List<Integer> list){
            int j=0;
            for(int i=0;i<list.size();i++){
                if(i==0 || list.get(i) != list.get(i-1)){
                    list.set(j++,list.get(i));
                }
            }
            return j;
    }

    //二分查找
    public static int query(List<Integer> list,int a){
        int l = 0;
        int r = list.size()-1;
        while(l<r){
            int mid = l + r >> 1;
            if( list.get(mid)>= a ){
               r = mid;
            }else{
                l = mid+1;
            }
        }
        //此处返回加1，是为了在求前缀和的时候，从1开始
        return r+1;
    }
}

class PII {
    int first;
    int second;

    public PII(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
