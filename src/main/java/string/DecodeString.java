package string;

import java.util.*;

public class DecodeString {

    int startIndex ;
    StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        String res = new DecodeString().decodeString("3[a2[c]]");

        System.out.println(res);

    }
    public String decodeString(String s) {
        Stack<Integer> stack = new Stack();

        char[] chars = s.toCharArray();
//        stack.push(Integer.valueOf(chars[0]));
        String res = decodeSubString(chars,stack);
        return res;


    }

    private String decodeSubString(char[] chars,Stack<Integer> stack) {
        StringBuffer sbtmp = new StringBuffer();
        for (;;) {
            if(startIndex>=chars.length){
                return sbtmp.toString();
            }
            if(chars[startIndex] == '['){
                stack.push(Integer.valueOf(String.valueOf(chars[startIndex-1])));
                startIndex++;
                String s = decodeSubString(chars,stack);
                sbtmp.append(s);
            }else if(chars[startIndex] == ']'){
                Integer count = stack.pop();
                String tmp = sbtmp.toString();
                for(int i = 1 ;i<count;i++){
                    sbtmp.append(tmp);
                }
                startIndex++;
            }else {
                if(chars[startIndex]>57){
                    sbtmp.append(chars[startIndex]);
                }
                startIndex++;
            }
        }
    }
}
