package 插入排序;

import java.util.Arrays;

public class insertSort {
    public static void main(String[] args) {
        int[] a={2,4,1,6,3,9};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void insertSort(int[] a){
        for(int i=1;i<a.length;i++){
            int j=i-1;
            int insertVal=a[i];
            while(j>=0 && insertVal<a[j]){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=insertVal;
        }
    }
}
