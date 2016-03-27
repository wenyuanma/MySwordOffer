package binaryTree;

/**
 * Created by ivy on 2016/3/27.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0;
        int inStart = 0;
        int inEnd = inorder.length-1;
        return buildTree(preorder, preStart, inorder, inStart,inEnd);
    }
    private TreeNode buildTree(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {

        if(preStart>preorder.length-1){
            return null;
        }
        //如果只有一个节点了，那么这个节点就是个叶子节点，
        //那么就直接返回这个节点,不再寻找其左右孩子了
        TreeNode root = new TreeNode(preorder[preStart]);
        if(preStart==preorder.length-1 || inStart==inEnd) return root;


        //在中序遍历中寻找根节点，用于分割出左右子树的节点们
        int left_length = 0;
        int index = inStart;
        for(;index<=inEnd;index++){
            if(root.val==inorder[index]){
                break;
            }else{
                left_length++;
            }
        }
        if(left_length>0){
            //说明存在左子树
            root.left = buildTree(preorder,preStart+1,inorder,inStart,inStart+left_length-1);
        }
        if(index<inEnd){
            root.right = buildTree(preorder,preStart+left_length+1,inorder,index+1,inEnd);
        }

        return root;



    }
}
