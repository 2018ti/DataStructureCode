package 二叉树;

import javafx.util.converter.ByteStringConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HuffManCode {
    public static void main(String[] args) {
        HuffMan huffMan = new HuffMan();
        String content="i like like like java do you like a java";
       byte[] bytes=content.getBytes();
        ArrayList<Node1> node1s = CountWeight(bytes);
        Node1 huffman = createHuffman(node1s);
        preOrder(huffman);
    }
    public static void  preOrder(Node1 root){
        System.out.println(root);
        if(root.leftNode!=null){
            preOrder(root.leftNode);
        }
        if(root.rightNode!=null){
            preOrder(root.rightNode);
        }
    }


    public  static   Node1 createHuffman(ArrayList<Node1> nodes){
        Collections.sort(nodes);
        while(nodes.size()>1){
            Node1 left=nodes.get(0);
            Node1 right=nodes.get(1);
            Node1 parent=new Node1(left.weight+right.weight,null);
            parent.setLeftNode(left);
            parent.setRightNode(right);
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
            Collections.sort(nodes);
        }
        return nodes.get(0);
    }

    public  static ArrayList<Node1> CountWeight(byte[] bytes){
        ArrayList<Node1> nodes = new ArrayList<>();
        HashMap<Byte, Integer> map = new HashMap<>();
        for(byte b : bytes){
            Integer count = map.get(b);
            if(count==null){
                map.put(b,1);
            }else {
                map.put(b,count+1);
            }
        }

        for (Map.Entry<Byte,Integer> entry: map.entrySet()){
            nodes.add(new Node1(entry.getValue(),entry.getKey()));
        }
        return nodes;
    }
}
class Node1 implements Comparable<Node1>{
    int weight;
    Byte c;
    Node1 leftNode;
    Node1 rightNode;

    @Override
    public int compareTo(Node1 node1) {
        return this.weight-node1.weight;
    }

    public Node1(int weight, Byte c) {
        this.weight = weight;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Node1{" +
                "weight=" + weight +
                ", c=" + c +
                '}';
    }

    public Node1 getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node1 leftNode) {
        this.leftNode = leftNode;
    }

    public Node1 getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node1 rightNode) {
        this.rightNode = rightNode;
    }
}
