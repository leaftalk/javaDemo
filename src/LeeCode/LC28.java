package LeeCode;

/**
 * @Description :实现strSTR()
 * @Author : LeafTalk
 * @Data : 2021/12/14
 */
public class LC28 {
    static int N = 50010;
    static int[] ne = new int[N];

    public static void main(String[] args) {
        String a = "hello";
        String b= "ll";
        System.out.println(strStr(a, b));
    }

    //kmp
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        //needle为空字符串
        if(m == 0)
        {
            return 0;
        }

        ne[0] = -1;
        //构建next数组
        for (int i = 1,j=-1; i < m; i++) {
            while(j!=-1 && needle.charAt(i) != needle.charAt(j+1)){
                j = ne[j];
            }

            if(needle.charAt(i) == needle.charAt(j+1)){
                 j++;
            }

            ne[i] = j;
        }

        for (int i = 0,j=-1; i < n; i++) {
            while(j!=-1 && haystack.charAt(i) != needle.charAt(j+1)){
                j = ne[j];
            }

            if(haystack.charAt(i) == needle.charAt(j+1))
            {
                j++;
            }

            if(j == m-1)
            {
                //匹配成功
                return i-j+1;
            }
        }
        //为匹配成功
        return -1;

    }

    //暴力破解法
    public static int strStr01(String haystack, String needle) {
      int n = haystack.length();
      int m = needle.length();

            if(m ==0){
                return 0;
            }
        int i = 0;
        int j =0;
        while(i<n && j<m){
            //匹配则往下依次匹配
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
               //不匹配则
                i = i-j +1;
                j = 0;
            }
        }

        if(j == m){
            return i-j;
        }else{
            return -1;
        }
    }
}
