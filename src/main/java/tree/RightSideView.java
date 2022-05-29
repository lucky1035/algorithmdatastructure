package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<TreeNode> tmpqueue = new LinkedList<>();
    List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return list;
        }
        queue.add(root);
        bfs(queue);

        return list;
    }

    public void bfs(Queue<TreeNode> leave) {
        tmpqueue.clear();
        if(queue.peek() == null ){
            return;
        }
        TreeNode rightNode = queue.peek();
        list.add(rightNode.val);
        while (queue.peek()!=null){
            TreeNode node = queue.poll();
            if(null!=node.right){
                tmpqueue.add(node.right);
            }
            if(null!=node.left){
                tmpqueue.add(node.left);
            }
        }
        queue.addAll(tmpqueue);
        bfs(queue);
    }

    public static void main(String[] args) {
        Integer[] a = {1,2};
//        Integer[] a = {1,null,3};
//        Integer[] a = {1,2,3,null,5,null,4};
        TreeNode root = TreeUtils.genareateTree(a);
        List<Integer> res = new RightSideView().rightSideView(root);
        System.out.println(res);
    }



}
