import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :
 * @Author : LeafTalk
 * @Data : 2021/10/3
 */
public class Demo13 {
    static int N = 100010;
    static int[] arr1 = new int[N];
    static int[] arr2 = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        String[] str02 = bf.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr1[i] = Integer.parseInt(str02[i]);
        }

        String[] str03 = bf.readLine().split(" ");
        for(int i=0;i<m;i++){
            arr2[i] = Integer.parseInt(str03[i]);
        }

        int i=0;
        int j=0;
        while(i<n && j<m){
            if(arr1[i] == arr2[j]) i++;
            j++;
        }
        if(i== n){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
