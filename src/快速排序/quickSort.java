package 快速排序;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] a={2,5,1,6,3,4,9,3};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void quickSort(int[] a,int start,int end){
        if(end<=start){
            return;
        }
        int low=start;
        int high=end;
        int standerd=a[low];
        while(low<high){
            while(low<high && a[high]>=standerd){
                high--;
            }
            a[low]=a[high];

            while(low<high && a[low]<=standerd){
                low++;
            }
            a[high]=a[low];
        }
        a[low]=standerd;
        quickSort(a,start,low);
        quickSort(a,low+1,end);
    }
}
