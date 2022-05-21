package sort;

import java.util.Random;

/**
 * 这个是正确的
 */
public class FindKthLargest {
    Random random = new Random();
    public int findKthLargest(int[] nums , int k ){
        //要找到的元素所在所以 ：前K 大 ，即倒数所以第K个
        int index = nums.length - k ;
        int left = 0;
        int right = nums.length-1;
        return  quickSelect(nums,left,right,index);
    }

    private int quickSelect(int[] nums, int left, int right, int index) {
        int q = randomPartition(nums,left,right);
        if(q==index){
            return nums[q];
        }else {
            return q<index?quickSelect(nums,q+1,right,index):quickSelect(nums,left,q-1,index);
        }
    }

    private int randomPartition(int[] nums, int left, int right) {
        //随机数范围: [0, r-l+1) 同时加l, 则是 [l, r+1) = [l, r] 也就是在这个[l,r] 中随机选一个索引出来
        int i = random.nextInt(right-left+1) +left ;
        swap(nums,i,right);
        int x = nums[right];

        int fst = left -1 ;
        for(int j = left;j<right;++j){
            if(nums[j]<=x){
                swap(nums,++fst,j);
//                fst++;
            }
        }
        swap(nums,fst+1,right);
        return fst+1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,5,6,4};
        int[] b = {3,2,3,1,2,4,5,5,6};

        int result = new FindKthLargest().findKthLargest(b,4);
        System.out.println(result);
    }
}
