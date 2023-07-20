package Trees;

import java.util.*;

public class TreeImplement {
    public static class Node {
        public int val;
        Node left, right;

        public Node(int key)
        {
            this.val = key;
            left = null;
            right = null;
        }
    }
    static Node root;
    public static void inorder(Node temp)
    {
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.val + " ");
        inorder(temp.right);
    }

    public ArrayList<Integer> reverseLevelOrder(Node node)
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(node.val);
        Queue<Node> q1 = new LinkedList<>();
        q1.add(node);
        while(!q1.isEmpty())
        {
            list.add(q1.element().val);
            if(q1.element().left != null)
            {
                q1.add(q1.element().left);
            }
            if(q1.element().right != null)
            {
                q1.add(q1.element().right);
            }

            q1.remove();
        }
        Collections.reverse(list);
        return list;

    }
    public static List<Integer> preOrder(Node temp){
        if(temp == null){
            return null;
        }
        System.out.print(temp.val + " ");
        preOrder(temp.left);
        preOrder(temp.right);

        return new ArrayList<>();
    }
    public static void postOrder(Node temp){
        if (temp == null) {
            return;
        }
        preOrder(temp.left);
        postOrder(temp.right);
        System.out.print(temp.val + " ");
    }

    public static void insert(Node temp, int val){
        if (temp == null) {
            root = new Node(val);
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(temp);
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new Node(val);
                break;
            }
            else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node(val);
                break;
            }
            else
                q.add(temp.right);
        }
    }

    ArrayList<Integer> leftView(Node root)
    {
        if(root==null) return null;
        ArrayList<Integer> s = new ArrayList<>();
        s.add(root.val);
        while(root.left!=null) s.add(root.left.val);
        return s;
    }
    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print("Inorder traversal : ");
        inorder(root);
        System.out.println();
        System.out.print("PostOrder traversal : ");
        postOrder(root);
        System.out.println();
        System.out.print("PreOrder traversal : ");
        preOrder(root);


    }
}

