package string;

public class MaximumSwap {
    public int maximumSwap(int num){
        String numStr = String.valueOf(num);
        char[] charArray = numStr.toCharArray();
        int[] numRightIndex = new int[10];
        for(int i = 0 ;i<charArray.length;i++){
            numRightIndex[charArray[i]-'0'] = i ;
        }

        for(int i=0 ; i<charArray.length;i++){
            for(int j = 9 ;j>charArray[i]-'0';j--){
                int lastIndex = numRightIndex[j];
                if(charArray[i]-'0'<j&&lastIndex>i){
                    swap(charArray,i,lastIndex);
                    return Integer.valueOf(String.valueOf(charArray));
                }
            }
        }
        return num;
    }

    public void swap(char[] charArray,int i,int j){
        char tmp = '0';
        tmp= charArray[i];
        charArray[i]=charArray[j];
        charArray[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSwap().maximumSwap(3849));

    }
}
