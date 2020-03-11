package leetcode.二叉树的直径_543;

/**
 * @author dadongge
 * @date 2020/3/10
 */
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int rightVal = getMax(root.right, 0);
        int leftVal = getMax(root.left,0);
        return rightVal + leftVal + 2;
    }

    private int getMax(TreeNode root, int val){
        if(root.right != null){
            getRight(root.right , val);
        }
        if(root.left != null){
            getLeft(root.left ,val);
        }
        return val;
    }

    private int getLeft(TreeNode root , int val){
        val++;
        getMax(root,val);
        return val;
    }

    private int getRight(TreeNode root,int val){
        val++;
        getMax(root,val);
        return val;
    }



    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        TreeNode leftNode1 = new TreeNode(4);
        TreeNode rightNode1 = new TreeNode(5);
        treeNode.right = rightNode;
        treeNode.left = leftNode;
        leftNode.left = leftNode1;
        leftNode.right = rightNode1;
        Solution solution = new Solution();
        int i = solution.diameterOfBinaryTree(treeNode);
        System.out.println(i);
    }
}
