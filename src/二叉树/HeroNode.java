package 二叉树;

public class HeroNode {
    private int num;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void proOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.proOrder();
        }
        if(this.right!=null){
            this.right.proOrder();
        }
    }
    //中序遍历
    public void midOrder(){
        if(this.left!=null){
            this.left.midOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.midOrder();
        }
    }
    //后序遍历
    public void behindOrder(){
        if(this.left!=null){
            this.left.behindOrder();
        }
        if(this.right!=null){
            this.right.behindOrder();
        }
        System.out.println(this);
    }
}

class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    public void preOrder(){
        if(root!=null){
            root.proOrder();
        }else System.out.println("树为空，不可遍历");
    }
    public void midorder(){
        if(root!=null){
            root.midOrder();
        }else System.out.println("树为空，不可遍历");
    }
    public void behindOrder(){
        if(root!=null){
            root.behindOrder();
        }else System.out.println("树为空 不可遍历");
    }

    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        HeroNode heroNode1=new HeroNode(1,"张三");
        HeroNode heroNode2=new HeroNode(2,"李四");
        HeroNode heroNode3=new HeroNode(3,"王五");
        HeroNode heroNode4=new HeroNode(4,"赵六");
        HeroNode heroNode5=new HeroNode(5,"hha");

        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode3);
        heroNode3.setRight(heroNode4);
        heroNode3.setLeft(heroNode5);
        binaryTree.setRoot(heroNode1);
        binaryTree.behindOrder();
    }
}
