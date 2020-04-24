package 二叉排序树;

import javafx.scene.transform.Rotate;

public class BinarySortTree {

    public static void main(String[] args) {
        int[] a={7,3,10,12,5,1,9};
        BinaryTree binaryTree = new BinaryTree();
        for(int i:a){
            binaryTree.addNode(i);
        }
        midOrder(binaryTree.root);
    }
    public static void preOrder(Node root){
        System.out.println(root.data);
        if(root.left!=null){
            preOrder(root.left);
        }
        if(root.right!=null){
            preOrder(root.right);
        }
    }

    public static void midOrder(Node root){
        if(root.left!=null){
            midOrder(root.left);
        }
        System.out.println(root.data);
        if(root.right!=null){
            midOrder(root.right);
        }
    }


}
class BinaryTree{
    Node root;
    public void addNode(int data){
        Node node = new Node(data);
        if (root==null){
            root=node;
        }else {
            root.add(node);
        }
    }

    public BinaryTree() {
    }
}

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public void add(Node node){
        if(node==null){
            return;
        }
        if (node.data > this.data) {
            if(this.right==null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }else {
            if(this.left==null){
                this.left=node;
            }else {
                this.left.add(node);
            }
        }
    }
}
