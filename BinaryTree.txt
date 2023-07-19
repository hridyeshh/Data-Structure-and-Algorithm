package Trees;

public class BinaryTree extends TreeNode {

    public BinaryTree(int val) {
        super(val);
    }

    public BinaryTree(int val, TreeNode left, TreeNode right) {
        super(val, left, right);
    }

    public TreeNode search(TreeNode root, int val) {
        if(root==null||root.val==val) return root;
        if(root.val>val){
            return search(root.left,val);
        }
        return search(root.right,val);
    }
}
