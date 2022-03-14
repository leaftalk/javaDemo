package LeeCode;

import java.util.Arrays;

/**
 * @Description :最长公共前缀
 * @Author : LeafTalk
 * @Data : 2021/12/9
 */
public class LC14 {
    public static void main(String[] args) {
        String[] a = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix02(a));
    }

    //横向扫描
    public static String longestCommonPrefix01(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        char[] matchchars = strs[0].toCharArray();
        String returnStr =strs[0];
        for (int i = 1; i < strs.length; i++) {
            char[] x = strs[i].toCharArray();

            int j =-1;
            while(j+1<returnStr.length() && j+1<x.length) {
                if(matchchars[j+1] - x[j+1] ==0){
                    j++;
                }else{
                    break;
                }
            }
            if(j==-1){
                return "";
            }else{
                returnStr = strs[0].substring(0,j+1);
            }

        }
        return returnStr;
    }

    //纵向扫描
    public static String longestCommonPrefix02(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int length = strs[0].length();
        int x =0;
        for (int i = 0; i < length; i++) {
            char a = strs[0].toCharArray()[i];
            for (int j = 1; j < strs.length; j++) {
                if(i == strs[j].length() || a - strs[j].toCharArray()[i] != 0){
                    return strs[0].substring(0,x);
                }
            }
            x++;

        }
        return strs[0];
    }

    //分治处理
    public static String longestCommonPrefix03(String[] strs) {
        if(strs == null || strs.length ==0){
            return "";
        }else{
               return getLongestCommonPrefix(strs,0,strs.length - 1);
        }
    }
    public static String getLongestCommonPrefix(String[] s,int start,int end){
        if(start == end){
            return s[start];
        }else{
            int mid = (start +end ) >> 1;
            String l = getLongestCommonPrefix(s,start,mid);
            String r = getLongestCommonPrefix(s,mid+1,end);
            return makeLongestCommonPrefix(l,r);
        }
    }

    public static String makeLongestCommonPrefix(String ls,String rs){
        int minlen = Math.min(ls.length(),rs.length());
        for (int i = 0; i < minlen; i++) {
            if(ls.charAt(i) != rs.charAt(i)){
                return ls.substring(0,i);
            }
        }
        return ls.substring(0,minlen);
    }

    //二分查找
    public static String longestCommonPrefix04(String[] strs) {
        if(strs == null || strs.length ==0){
            return "";
        }
        int minlen = Integer.MAX_VALUE;
        for(String s:strs){
            minlen = Math.min(minlen,s.length());
        }
        int low =0;
        int high = minlen;
        while(low<high){
            int mid = (low +high) >> 1;
            if(isTrue(strs,mid)){
                low = mid +1;
            }else{
                high = mid;
            }
        }
        return strs[0].substring(0,low);

    }

    public static boolean isTrue(String[] s,int mid){
        int len = s.length;
        String str = s[0].substring(0, mid);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < mid; j++) {
                if(s[i].charAt(j) != str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }


}
