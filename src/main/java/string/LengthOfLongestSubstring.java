package string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    Map<Character,Integer> charMap = new HashMap<Character,Integer>();
    int maxLenght  ;
    int lengthOfLongestSubstring(String s) {
        int fstIndex =0;
        int secondIndex =1;
        if(s.length()==0){
            return maxLenght;
        }
        if(s.length()==1){
            return 1;
        }
        charMap.put(s.charAt(0),0);
            while(secondIndex<s.length()){
                Integer existIndex = charMap.get(s.charAt(secondIndex));
                if(null!=existIndex){
                    if(maxLenght<(secondIndex-fstIndex)){
                        maxLenght = (secondIndex-fstIndex);
                    }
                    //将左指针到重复值中的字符从缓存中清除。
                    for(int i = fstIndex;i<existIndex;i++){
                        charMap.remove(s.charAt(i));
                    }
                    //左指针移动到重复值得位置，
                    fstIndex = existIndex+1;
                    charMap.put(s.charAt(secondIndex),secondIndex);
                    secondIndex++;
                    continue;
                }
                if(maxLenght<(secondIndex-fstIndex)+1){
                    maxLenght = (secondIndex-fstIndex)+1;
                }
                charMap.put(s.charAt(secondIndex),secondIndex);
                secondIndex++;
            }
            return maxLenght;
    }

    public static void main(String[] args) {
        int a  = new LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb");
        System.out.println(a);

    }
}
