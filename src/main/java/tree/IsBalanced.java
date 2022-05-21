package tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsBalanced {
//    public boolean isBalanced(TreeNode root) {
//
//        LinkedList<TreeNode> queue1 = new LinkedList<>();
//        LinkedList<TreeNode> queue2 = new LinkedList<>();
//        Integer maxHeight = null ;
//        Integer minHeight = null;
//
//        int height = 0;
//
//        if(root == null){
//            return  true;
//        }
//        queue1.push(root);
//        height++;
//        while(!queue1.isEmpty()){
//            TreeNode node = queue1.pollLast();
//            TreeNode left = node.left;
//            if(left == null){
//                if(minHeight == null){
//                    minHeight = height;
//                    maxHeight = height;
//                }
//                if(maxHeight<height){
//                    maxHeight = height;
//                }
//                if ((maxHeight-minHeight)>1){
//                    return false;
//                }
//            }else {
//                queue2.push(left);
//            }
//            TreeNode right = node.right;
//            if(right == null){
//                if(minHeight == null){
//                    minHeight = height;
//                    maxHeight = height;
//                }
//                if(maxHeight<height){
//                    maxHeight = height;
//                }
//                if ((maxHeight-minHeight)>1){
//                    return false;
//                }
//            }else {
//                queue2.push(right);
//            }
//            System.out.println("遍历完节点："+node.val +" maxheight :"+maxHeight +" minheight :"+minHeight);
//        }
//        return true;
//    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return  true;
        }

        return Math.abs(height(root.left)-height(root.right))<= 1&&isBalanced(root.left)&&isBalanced(root.right);
    }

    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(height(node.left),height(node.right))+1;
    }


    public static void main(String[] args) {
        Integer[] a = {};
        TreeNode root  = TreeUtils.genareateTree(a);


        Boolean result = new IsBalanced().isBalanced(root);

        System.out.println(result);
    }
}
