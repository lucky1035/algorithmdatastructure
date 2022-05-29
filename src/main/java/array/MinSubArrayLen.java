package array;

public class MinSubArrayLen {

//    public int minSubArrayLen(int s, int[] nums) {
//        int n = nums.length;
//        if (n == 0) {
//            return 0;
//        }
//        int ans = Integer.MAX_VALUE;
//        int start = 0, end = 0;
//        int sum = 0;
//        while (end < n) {
//            sum += nums[end];
//            while (sum >= s) {
//                ans = Math.min(ans, end - start + 1);
//                sum -= nums[start];
//                start++;
//            }
//            end++;
//        }
//        return ans == Integer.MAX_VALUE ? 0 : ans;
//    }


    public int minSubArrayLen(int target, int[] nums) {

        int p1 = 0 ;
        int p2=0;
        int distence = Integer.MAX_VALUE ;
        int windowLen = 0 ;
        while(p1<nums.length&&p2<nums.length){

            int result = calculateWindow(nums,p1,p2);
            if(target>result){
                p2++;
                if(Integer.MAX_VALUE != distence ){
                    p1++;
                }
            } else{
                distence = Math.min(distence, p2 - p1 + 1);
                p1++;
//                if( windowLen<distence){
//                    distence = windowLen;
//                    if(distence == 1 ){
//                        return distence;
//                    }
//                    p1++;
//                }else if (windowLen==distence){
//                    p1++;
//                }
            }
        }
        return  Integer.MAX_VALUE == distence?0:distence;
    }

    private int calculateWindow(int[] nums, int p1, int p2) {
        int result = 0 ;
        for(int i = p1;i<=p2;i++){
            result +=nums[i];
        }
        return result;
    }

    public static void main(String[] args) {

        int target = 4;
         int a [] = {1,4,4};
//        int target = 7;
//         int a [] = {2,3,1,2,4,3};
//         int target = 11;
//         int a [] = {1,1,1,1,1,1,1,1};;
//                 int target = 15;
//         int a [] = {5,1,3,5,10,7,4,9,2,8};
         int len = new MinSubArrayLen().minSubArrayLen(target ,a);
        System.out.println(len);
    }
}
