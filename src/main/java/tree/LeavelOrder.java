package tree;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LeavelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(null==root){
            return result;
        }
        Queue<TreeNode> orderQ = new LinkedList();
        Queue<TreeNode> saveQ = new LinkedList();
        orderQ.add(root);

        while(!orderQ.isEmpty()||!saveQ.isEmpty()){
            List<Integer> leavelReuslt = new LinkedList<>();
            while(!orderQ.isEmpty()){
                TreeNode node = orderQ.poll();
                leavelReuslt.add(node.val);
                if(null!=node.left){
                    saveQ.add(node.left);
                }
                if(null!=node.right){
                    saveQ.add(node.right);
                }
            }
            if(orderQ.isEmpty()&&!saveQ.isEmpty()){
                Queue<TreeNode> tmp = orderQ;
                orderQ = saveQ;
                saveQ = tmp;
            }
            result.add(leavelReuslt);
        }
    return result;

    }

    public static void main(String[] args) {
        Integer a [] = {};
//        Integer a [] = {3,9,20,null,null,15,7};
        TreeNode root = TreeUtils.genareateTree(a) ;
        List<List<Integer>> result = new LeavelOrder().levelOrder(root);

        System.out.println(JSONArray.toJSONString(result));

    }
}
