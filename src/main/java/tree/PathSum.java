package tree;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class PathSum {
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return result;
        }

        Stack stack = new Stack<TreeNode>();
        stack.add(root);
        firstOrder(stack,targetSum);
        return result;
    }

    public void firstOrder(Stack<TreeNode> stack, int targetSum){
        TreeNode node = stack.peek();
        targetSum -=node.val;
        if(0==targetSum&&node.left==null&&null==node.right){
            List<Integer> path = new LinkedList<>(stack.stream().map(t->{return t.val;}).collect(Collectors.toList()));
            result.add(path);
        }

        if(null!=node.left){
            stack.add(node.left);
            firstOrder(stack,targetSum);
            stack.pop();
        }

        if(null!=node.right){
            stack.add(node.right);
            firstOrder(stack,targetSum);
            stack.pop();
        }
    }


    public static void main(String[] args) {
//        Integer a []={5,4,8,11,null,13,4,7,2,null,null,5,1};
//        Integer b = 22;
        Integer a []={-2,null,-3};
        Integer b = -5;
        TreeNode root =  TreeUtils.genareateTree(a);
        List<List<Integer>> result = new PathSum().pathSum(root,b);

        System.out.println(JSONArray.toJSONString(result));
    }
}
