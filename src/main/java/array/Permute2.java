package array;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permute2 {

    List<List<Integer>> paths = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {

        if(nums.length==0){
            return  null;
        }
        Arrays.sort(nums);

        List<Integer> remains = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(new LinkedList<>(),remains);

        return paths;
    }

    private void dfs(List<Integer> path,List<Integer> remains) {

        if(remains.size()==0){
            paths.add(path);
        }
        List<Integer> tmpRemains = new LinkedList<>();
        for(int i = 0 ; i<remains.size();i++){

            List<Integer> newPath = new LinkedList<>();
            newPath.addAll(path);
            newPath.add(remains.get(i));
            List<Integer> newRemains = new LinkedList<>();
            newRemains.addAll(tmpRemains);
            newRemains.addAll(remains.subList(i+1,remains.size()));
            if(i>0&&remains.get(i)==remains.get(i-1)){
                tmpRemains.add(remains.get(i));
                continue;
            }
            dfs(newPath,newRemains);

            tmpRemains.add(remains.get(i));
        }



    }


    public static void main(String[] args) {
        int[] a = {1,2,1};
        List<List<Integer>> results = new Permute2().permuteUnique(a);
        for(List<Integer> result : results){
            System.out.println(result);
        }
    }
}
