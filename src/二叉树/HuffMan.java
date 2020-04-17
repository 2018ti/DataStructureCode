package 二叉树;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HuffMan {
    public static void main(String[] args) {
        int[] a={13,7,8,3,29,6,1};
        Node node = CreateHuffMan(a);
        preOrder(node);
    }
    public static Node CreateHuffMan(int[] a){
        ArrayList<Node> lists = new ArrayList<Node>();
        for(int value: a){
            Node node = new Node(value);
            lists.add(node);
        }
        Collections.sort(lists);
        while(lists.size()!=1) {
            Node node1 = lists.get(0);
            Node node2 = lists.get(1);
            Node parent = new Node(node1.getWeight() + node2.getWeight());
            parent.setLeftNode(node1);
            parent.setRightNode(node2);
            lists.add(parent);
            lists.remove(node1);
            lists.remove(node2);
            Collections.sort(lists);
        }
        return lists.get(0);
    }
    public static void preOrder(Node root){
        System.out.println(root.getWeight());
        if(root.getLeftNode()!=null){
            preOrder(root.getLeftNode());
        }
        if(root.getRightNode()!=null){
            preOrder(root.getRightNode());
        }
    }
}
class Node implements Comparable<Node>{
    private int weight;
    private Node leftNode;
    private Node rightNode;

    @Override
    public int compareTo(Node node) {
        return this.weight-node.weight;
    }

    public Node(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "weight=" + weight +
                '}';
    }
}
