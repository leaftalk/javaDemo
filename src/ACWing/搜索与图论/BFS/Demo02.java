package 搜索与图论.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Description : 八数码问题
 * @Author : LeafTalk
 * @Data : 2021/12/3
 */
public class Demo02 {

    public static int bfs(String s){
        Queue<String> queue = new LinkedList<String>();
        Map<String,Integer> d = new HashMap<String,Integer>(); //记录每个结果 的交换次数
        queue.add(s);
        d.put(s,0);

        String end = "12345678x";
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        while(queue.size() > 0){
            String t = queue.poll();

            if(t.equals(end)){
                return d.get(t);
            }

            int distance = d.get(t);
            int a = t.indexOf('x');
            int x = a / 3, y = a % 3; //将一维数组中的位置，转化为二维数组坐标
            for (int i = 0; i < 4; i++) {
                int x2 = x + dx[i];
                int y2 = y + dy[i];
                if(x2>=0 && x2<3 && y2>=0 && y2<3){
                    String newstr = swap(t,a,x2*3+y2);
                    if(!d.containsKey(newstr)){
                        queue.add(newstr);
                        d.put(newstr,distance + 1);
                    }
                }

            }

        }
        return -1;
    }

    public static String swap(String s,int a,int b){
            StringBuilder sb =new StringBuilder(s);
            sb.setCharAt(a,s.charAt(b));
            sb.setCharAt(b,'x');

            return sb.toString();

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        System.out.println(bfs(sb.toString()));
    }
}
