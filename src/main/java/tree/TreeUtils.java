package tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {

    public static TreeNode genareateTree(Integer[] args) {
        if(args.length==0){
            return null;
        }
        LinkedList<TreeNode> queue  = new LinkedList();
        TreeNode root = new TreeNode(args[0]);
        queue.push(root);
        int index = 1 ;
        while (!queue.isEmpty()){
            TreeNode node = queue.pollLast();
            if(index< args.length){
                Integer val = args[index];
                if(val != null){
                    TreeNode left = new TreeNode(val);
                    queue.push(left);
                    node.left = left;
                }
                index ++ ;
            }

            if(index< args.length){
                Integer val = args[index];
                if(val != null){
                    TreeNode right = new TreeNode(val);
                    queue.push(right);
                    node.right = right;
                }
                index ++ ;
            }

        }

        return  root;

    }
    public static int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int height=1;
        while(!queue.isEmpty()){
            TreeNode node=queue.peek();
            System.out.println("node 节点： " +node.val+ " 高度：" +height);
            if(node.left==null&&node.right==null){
                break;
            }else{
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                queue.poll();
                height++;
            }


        }
        return height;
    }

    public static void main(String[] args) {
        Integer[] a = {1,2,2,3,3,null,null,4,4};
        TreeNode root  = TreeUtils.genareateTree(a);
        System.out.println(TreeUtils.getHeight(root));
//        Boolean result = new IsBalanced().isBalanced(root);

//        System.out.println(result);
    }
}
