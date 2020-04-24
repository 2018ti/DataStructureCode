package 常用算法.二分非递归;


public class BinarySearchNorec {

    public static void main(String[] args) {
        int[] a={1,3,5,7,9,23,45};
        System.out.println(BinarySearch(a,7));
    }

    public static int BinarySearch(int[] arr,int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left<=right) {//继续查找
            int mid=(left+right)/2;
            if(target>arr[mid]){
                left=mid+1;
            }else if(target<arr[mid]){
                right=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
