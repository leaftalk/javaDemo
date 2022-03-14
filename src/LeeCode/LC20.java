package LeeCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 有效括号
 * @Author : LeafTalk
 * @Data : 2021/12/10
 */
public class LC20 {
    static int N = 10010;
    static char[] arr = new char[N];

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid02(s));
    }

    public static boolean isValid01(String s) {
        int rr = -1;
        //只有字符串长度为偶数才能匹配成功
        if(s.length() %2 !=0){
            return false;
        }
        Map<Character,Character> map =new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(!map.containsKey(c[i])){
                //左括号入栈
                arr[++rr] = c[i];
            }else{
                //右括号 进行匹配
                if(rr!=-1){
                    char chr = arr[rr--];
                    //右括号匹配
                    if(map.get(c[i]) != chr){
                        //匹配失败
                        return false;
                    }
                }else{
                    return false;
                }

            }
        }
        //循环结束之后，检查栈是否为空
        if(rr!=-1){
            return false;
        }
        return true;
    }

    //ascll码差值求解
    public static boolean isValid02(String s) {
            char[] c = s.toCharArray();
            int rr = -1;
        for (int i = 0; i < c.length; i++) {
            if(rr==-1){
                arr[++rr] = c[i];
            }else if(c[i] - arr[rr] ==1 || c[i] - arr[rr] == 2){
                rr--;
            }else {
                arr[++rr] = c[i];
            }
        }
        if(rr != -1){
            return false;
        }
        return true;
    }
}
