package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {

        if(nums.length==0){
            return  null;
        }
        Arrays.sort(nums);
        return assemble(nums,nums.length);
    }

    private List<List<Integer>> assemble(int[] nums, int length) {
        if(length==1){
            List list = new ArrayList<>();
            list.add(nums[0]);
            List collection = new ArrayList<>();
            collection.add(list);
            return collection;
        }
        int a = nums[length-1];
        List<List<Integer>> result = assemble(nums,length-1);
        return assembleResult(result,a);
    }

    private List<List<Integer>> assembleResult(List<List<Integer>> parame, int a) {
        List<List<Integer>>  tmp = parame ;
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> list :tmp){
            List<List<Integer>> insertResult = insert(list,a);
            result.addAll(insertResult);
        }
        return result;
    }

    private List<List<Integer>>  insert(List<Integer> parame, int a) {
        List results = new ArrayList<List<Integer>>();
        for(int i = 0 ; i<= parame.size();i++){
            List<Integer> result = new ArrayList<>(parame);
            result.add(i,a);
            results.add(result);
            if(i<parame.size()&&a==result.get(i+1)){
                i++;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] a = {1,2,1};
        List<List<Integer>> results = new Permute().permute(a);
        for(List<Integer> result : results){
            System.out.println(result);
        }
    }
}
