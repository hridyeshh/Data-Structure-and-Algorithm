package Trees;

import java.util.Stack;

public class BinarySearchTree extends TreeNode {
    public BinarySearchTree(int val) {
        super(val);
    }

    public BinarySearchTree(int val, TreeNode left, TreeNode right) {
        super(val, left, right);
    }
    void insert(int key) { root = insertRec(root, key); }

    public TreeNode insertRec(TreeNode root, int key){
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }


        else if (key < root.val)
            root.left = insertRec(root.left, key);
        else if (key > root.val)
            root.right = insertRec(root.right, key);

        return root;
    }
    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) return root;
        if (val < root.val) {
            root.left = deleteNode(root.left, val);
        } else if (val > root.val) {
            root.right = deleteNode(root.right, val);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.val = minValue(root.right);
            root.right = deleteNode(root.right, val);
        }

        return root;
    }
    public int minValue(TreeNode root){
        int minV = root.val;
        while(root.left != null){
            minV = root.left.val;
            root = root.left;
        }
        return minV;
    }
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        double left_child_value = -Double.MAX_VALUE;
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val<=left_child_value) return false;
            left_child_value = root.val;
            root = root.right;
        }
        return true;
    }
}
