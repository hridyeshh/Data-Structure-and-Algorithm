package Trees;

import java.lang.reflect.Array;
import java.util.*;


public class TreeNode {
    TreeNode prev = null;
    TreeNode head = null;
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode root;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // leetcode questions
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>(); // saving leaves of the parent node in an arraylist
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2); // equals is a method of arraylist
    }

    public void dfs(TreeNode node, List<Integer> leaves) { // a function that takes a treeNode input and a list of leaves
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            leaves.add(node.val); // if the node has no children further, add the node to the list
            return;
        }
        // This is guaranteed to visit each leaf in left-to-right order, as left-children are fully explored before right-children.

        dfs(node.left, leaves); // dfs stands for depth first search
        // first node stored will be left and then the right node will be stored
        dfs(node.right, leaves); // purpose of dfs function is to add the leaf to the leaves arraylist, if that node.left or .right is null
    }

    public void insert(TreeNode temp, int val) {
        if (temp == null) {
            root = new TreeNode(val);
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new TreeNode(val);
                break;
            } else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new TreeNode(val);
                break;
            } else
                q.add(temp.right);

        }
    }

    public int maxDepth(TreeNode temp) {
        if (temp == null) {
            return 0;
        }
        int lDepth = maxDepth(temp.left);
        int rDepth = maxDepth(temp.right);
        if (lDepth > rDepth) {
            return (lDepth + 1);
        } else {
            return (rDepth + 1);
        }
    }

    public int size(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return (size(node.left) + 1 + size(node.right)); // node.left or node.right is also a node and when that node equates to zero that is there's no more nodes, then this will
            // go for the base case where it will return 0, so till it's not the base case it will
            // go to node.left and node.right and will add 1 to their sum

        }
    }

    static int maxLevel = 0; // static variable that defines the level of the pointer
    // it will keep updating itself after every iteration

    void leftView(TreeNode node, int level) {
        if (node == null) return;

        if (maxLevel < level) { // level is also the pointer pointing to the level
            // starting from 1 initially and maxLevel pointer points to 0
            System.out.print(" " + node.val);
            maxLevel = level;// updating the value of maxLevel after every iteration
            // and equating it to the current value of the 'level'

            leftView(node.left, level + 1);
            leftView(node.right, level + 1);
        }
    }

    void leftView() {
        maxLevel = 0;
        leftView(root, 1); // root corresponds to the head node
    }

    private ArrayList<Integer> TopView(TreeNode root) {
        class QueueObj {
            TreeNode node;
            int hd;

            QueueObj(TreeNode node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        ArrayList<Integer> s = new ArrayList<>();
        Queue<QueueObj> q = new LinkedList<QueueObj>();
        Map<Integer, TreeNode> topViewMap = new TreeMap<Integer, TreeNode>();

        if (root == null) {
            return s;
        } else {
            q.add(new QueueObj(root, 0));
        }

        while (!q.isEmpty()) {
            QueueObj tmpNode = q.poll();
            if (!topViewMap.containsKey(tmpNode.hd)) {
                topViewMap.put(tmpNode.hd, tmpNode.node);
            }

            if (tmpNode.node.left != null) {
                q.add(new QueueObj(tmpNode.node.left,
                        tmpNode.hd - 1));
            }
            if (tmpNode.node.right != null) {
                q.add(new QueueObj(tmpNode.node.right,
                        tmpNode.hd + 1));
            }
        }
        for (Map.Entry<Integer, TreeNode> entry : topViewMap.entrySet()) {
            s.add(entry.getValue().val);
        }
        return s;
    }

    public void convertToDll(TreeNode root){
        if(root == null) return;
        convertToDll(root.left);
        if(prev==null) head = root;
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertToDll(root.right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return ans;
    }

    private int ans = 0;

    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;

        final int l = maxDepth2(root.left);
        final int r = maxDepth2(root.right);
        ans = Math.max(ans, l + r); // ans will be updated with the value l+r everytime
        return 1 + Math.max(l, r);
    }
    public boolean leafHeight(TreeNode temp) {
        if(maxDepth2(temp.left)==maxDepth2(temp.right)) return true;
        return false;
    }
    public int Ceil(TreeNode root, int val) {
        int ceil = -1;
        while(root != null) {
            if(root.val==val){
                ceil = root.val;
                return ceil;
            }
            if(val>root.val){
                root = root.right;
            }
            else{
                ceil = root.val;
                root=root.left;
            }
        }
        return ceil;
    }
    public int Floor(TreeNode root, int val) {
        int floor = -1;
        while (root != null) {
            if (root.val == val) {
                floor = root.val;
                return floor;
            }
            if (val > root.val) {
                floor = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>(Arrays.asList(root));
        boolean isLeftToRight = true;

        while (!q.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            for (int i = q.size(); i > 0; --i) {
                TreeNode node = q.poll();
                if (isLeftToRight)
                    currLevel.add(node.val);
                else
                    currLevel.add(0, node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            ans.add(currLevel);
            isLeftToRight = !isLeftToRight;
        }

        return ans;
    }
}
