package 排序算法.冒泡排序;

public class MaoPaoSort {

    public static void main(String[] args) {
            int[] a={1,3,5,2,4,2,1,5,6};
            MaoPaoSort(a);
            for(int i=0;i<a.length;i++){
                System.out.println(a[i]);
            }
    }

    public static void MaoPaoSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }





    }


}
