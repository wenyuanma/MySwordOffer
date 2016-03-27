package binaryTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by ivy on 2016/3/27.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        pathSum(root,paths,new LinkedList<Integer>(),sum,0);
        return paths;
    }
    public void pathSum(TreeNode node,List<List<Integer>> paths,
                        LinkedList<Integer> stack,int sum,int currentSum){
        if(node==null) return;

        currentSum += node.val;
        stack.push(node.val);
        boolean isLeaf = (node.left==null) && (node.right==null);
        if(sum==currentSum){
            if(isLeaf){
                //证明找到了一条路径
                ArrayList<Integer> path = new ArrayList<Integer>();
                for(int i = stack.size()-1;i>=0;i--){
                    path.add(stack.get(i));
                }
                //currentSum =0;
                paths.add(path);
            }else{
                //因为node的val有可能是负数，所以currentSum==sum但不是叶子节点也有可能成为一条路径
                if(node.left!=null) pathSum(node.left,paths,stack,sum,currentSum);
                if(node.right!=null)pathSum(node.right,paths,stack,sum,currentSum);
            }
        }else{
            if(!isLeaf){
                if(node.left!=null) pathSum(node.left,paths,stack,sum,currentSum);
                if(node.right!=null)pathSum(node.right,paths,stack,sum,currentSum);
            }
        }
        stack.pop();

    }
}