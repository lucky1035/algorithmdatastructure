package tree;

public class Symmetric {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return false;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (null == right && null == left) {
            return true;
        }

        StringBuffer sbL = new StringBuffer();
        StringBuffer sbR = new StringBuffer();
        this.dfsL(left, sbL);
        this.dfsR(right, sbR);

        System.out.println("sbL" + sbL.toString());
        System.out.println("sbR" + sbR.toString());

        return sbL.toString().equals(sbR.toString());


    }

    public void dfsR(TreeNode root, StringBuffer sb) {
        if (root.left != null) {
            dfsR(root.left, sb);
        }else {
            sb.append("null");
        }
        sb.append(root.val);
        if (root.right != null) {
            dfsR(root.right, sb);
        }else {
            sb.append("null");
        }
        return;
    }

    public void dfsL(TreeNode root, StringBuffer sb) {
        if (root.right != null) {
            dfsR(root.right, sb);
        }else {
            sb.append("null");
        }
        sb.append(root.val);

        if (root.left != null) {
            dfsR(root.left, sb);
        }else {
            sb.append("null");
        }
        return;
    }
}
