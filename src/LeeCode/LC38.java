package LeeCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 罗马数字转整数
 * @Author : LeafTalk
 * @Data : 2021/12/8
 */
public class LC38 {

    public static void main(String[] args) {
        String s = "LVIII";
        int len = s.length();

        int ret = 0;
        for (int i = 0; i < len; i++) {
            int a = getValue(s.charAt(i));
            if(i==len-1){
                ret += getValue(s.charAt(i));
                break;
            }
            int b = getValue(s.charAt(i+1));
            //左边数字大
            if(a>=b){
                ret += getValue(s.charAt(i));
            }else{
                ret -= getValue(s.charAt(i));
            }
        }
        System.out.println(ret);
    }

    public static int getValue(char s){
        switch(s){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
