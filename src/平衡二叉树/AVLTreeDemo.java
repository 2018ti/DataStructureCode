package 平衡二叉树;

import com.sun.jdi.Value;
import com.sun.source.tree.ReturnTree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] a={1,4,2,5,6,3,9};
        AVLTree avlTree = new AVLTree();
        avlTree.TreeaddNode(a);
        System.out.println("旋转后左子树的高度");
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println("旋转后右子树的高度");
        System.out.println(avlTree.getRoot().rightHeight());
    }
}
class  AVLTree{
    Node root;

    public Node getRoot() {
        return root;
    }

    public void TreeaddNode(int[] a){
       for(int i : a){
           Node node = new Node(i);
           if(root==null){
               root=node;
           }else {
               root.addNode(node);
           }
       }
    }
    //返回以当前节点为根节点的树的高度
    public int getHeight(){
        return root.getHeight();
    }

    public AVLTree() {
    }

    public void preOrder(){
        if(root==null){
            return;
        }
        else {
            root.preOrder();
        }
    }
    public void midOrder(){
        if(root==null){
            return;
        }else
            root.midOrder();;
    }
}
class  Node{
    int data;
    Node left;
    Node right;

    public int leftHeight(){
        if(left==null){
            return 0;
        }
        return left.getHeight();
    }
    public int rightHeight(){
        if(right==null){
            return 0;
        }
        return right.getHeight();
    }

    public int getHeight(){
        return Math.max((left==null?0:left.getHeight()),(right==null?0:right.getHeight()))+1;
    }

    //左旋
    public void leftRotate(){
        Node node = new Node(data);
        node.left=left;
        node.right=right.left;
        data=right.data;
        left=node;
        right=right.right;
    }

    public void addNode(Node node){
        if(node.data>this.data) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addNode(node);
            }
        }
        else {
            if(this.left==null){
                this.left=node;
            }else {
                this.left.addNode(node);
            }
        }

        if(rightHeight()-leftHeight()>1){
            leftRotate();
        }
    }

    public Node(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void preOrder(){
        System.out.println(this.data);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    public void midOrder(){
        if(this.left!=null){
            this.left.midOrder();
        }
        System.out.println(this.data);
        if(this.right!=null){
            this.right.midOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
