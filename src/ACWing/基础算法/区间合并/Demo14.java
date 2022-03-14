package ACWing.基础算法.区间合并;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Description :区间合并
 * @Author : LeafTalk
 * @Data : 2021/10/3
 */
public class Demo14 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine().split(" ")[0]);
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] str = bf.readLine().split(" ");
            map.put(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
            list.add(Integer.parseInt(str[0]));
        }
        Collections.sort(list);
        int l = Integer.MIN_VALUE,r = Integer.MIN_VALUE, res =0;
        for(Integer i : list){
            System.out.println(map.get(i));
            if(i> r){
                    ++res;
                l = i;
                r = map.get(i);
            }else{
                r= Math.max(r,map.get(i));
            }
        }
        System.out.println(res);
    }

}
