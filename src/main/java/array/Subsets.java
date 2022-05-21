package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {


    public List<List<Integer>> subsets(int[] nums) {

        return assemble(nums,nums.length);
    }

    private List<List<Integer>> assemble(int[] nums, int length) {
        if(length==0){
            List<List<Integer>> results = new ArrayList<>();
            results.add(new ArrayList<>());
            return results;
        }
        int a= nums[length-1];
        List<List<Integer>> incrementResults = new ArrayList<>();
        List<List<Integer>> results =  assemble(nums,length-1 );
        for (List list : results){
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(list);
            tmp.add(a);
            incrementResults.add(tmp);
        }
        results.addAll(incrementResults);

        return results;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> results = new Subsets().subsets(a);
        for(List<Integer> result : results){
            System.out.println(result);
        }
    }
}
