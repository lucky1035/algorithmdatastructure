package array;

public class FirstMissingPositive {
    /**
     * 原地map
     * 如果数组长度为n 那么 最小正整数有两种情况 ：
     * 1.数组从1开始  到n 所有数字都在数组那 最大正整数为 n+1
     * 2.1到n 中有个缺失的，那么
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //将负数 转化为 n +1  位置
        for(int i =0 ;i<n;i++){
            if(nums[i]<=0){
                nums[i] = n+1;
            }
        }
        //将<n 的数据再相应的 下标位置 做记录。
        for(int i =0 ;i<n;i++){
            int num = Math.abs(nums[i]);
            if(0<num&&num<=n){
                nums [num-1] = - Math.abs(nums [num-1]);
            }
        }

        /**
         * 若数组中全部为负数则 ，第一正整数为 n+1
         * 否则第一个正数的下标+1位 缺失正整数
         */
        for(int i =0 ;i<n;i++){
            if(nums[i]>0){
                return  i +1  ;
             }
        }
        return n+1;
    }

    /**
     * 原地map
     * 如果数组长度为n 那么 最小正整数有两种情况 ：
     * 1.数组从1开始  到n 所有数字都在数组那 最大正整数为 n+1
     * 2.1到n 中有个缺失的，那么
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        int i =0 ;
        while(true){
            if(i == n ){
                break;
            }
            int num = nums[i];
            if(num == i ){
                i++;
                continue;
            }
            if(0<num&&num<=n){
                swap(nums,num-1,i);
            }else {
                i++;
            }
        }

        for(int a = 0 ;a<n;a++){
            if(a+1 != nums[a]){
                    return a+1;
            }
        }
        return n+1;

    }

    public void swap(int[] charArray,int i,int j){

        int tmp  = charArray[i];
        charArray[i]=charArray[j];
        charArray[j] = tmp;
    }



    public static void main(String[] args) {
//        int[] a = {1,2,0};
//        int[] a = {3,4,-1,1};
        int[] a = {7,8,9,11,12};
//        int[] a = {1,1};
        int res = new FirstMissingPositive().firstMissingPositive(a);
        System.out.println(res);
    }

}
