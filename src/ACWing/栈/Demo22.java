package 栈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description : 表达式求值
 * @Author : LeafTalk
 * @Data : 2021/10/14
 */
public class Demo22 {
    //存放数字
    static Stack<Integer> num = new Stack<>();
    //存放 运算符
    static Stack<Character> ops = new Stack<>();

    public static void cal(){
        int a =  num.pop();
        int b = num.pop();
        char op = ops.pop();

        switch (op){
            case '+':
                num.push(b+a);
             break;
            case '-':
                num.push(b-a);
                break;
            case '*':
                num.push(b*a);
                break;
            case '/':
                num.push(b/a);
                break;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //存储运算符优先级
        Map<Character,Integer> map = new HashMap<>();
        map.put('(',0);
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        char[] chr = bf.readLine().toCharArray();

        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < chr.length; i++) {
            char a = chr[i];
            if(Character.isDigit(a)){
                sb.append(a);
                int j=i+1;
                while(j<chr.length && Character.isDigit(chr[j])){
                    sb.append(chr[j]);
                    j++;
                }
                num.push(Integer.parseInt(sb.toString()));
                sb.delete(0,sb.length());
                i = j-1;
            }else if(a == '('){
                ops.push(a);
            }else if(a == ')'){
                while(ops.peek() != '('){
                    cal();
                }
                //弹出左括号
                ops.pop();
            }else{
                //如果栈顶运算符优先级比当前的大，则 先计算优先级大的计算
                while(!ops.empty() && map.get(ops.peek()) >= map.get(a)){
                    cal();
                }
                ops.push(a);
            }
        }
        while(ops.size()>0){
            cal();
        }

        System.out.println(num.peek());
    }
}
