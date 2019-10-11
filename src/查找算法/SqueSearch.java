package 查找算法;

public class SqueSearch {
    public static void main(String[] args) {
        int[] arr={2,3,2,15,6,3,6};
        int index=squeSearch(arr,4);
        if(index==-1){
            System.out.println("该数组中没有该元素");
        }else
            System.out.println("该元素的下标为"+index);
    }
    public static int squeSearch(int[] arr,int value){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }
}
