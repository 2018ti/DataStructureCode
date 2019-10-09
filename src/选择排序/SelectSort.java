package 选择排序;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] a={1,2,4,6,3,9,4,2,8,5,2,5};
        selectsort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void selectsort(int[] array){
        int index=0;
        boolean flag=false;
        int temp;
        for(int i=0;i<array.length;i++){
            int min=array[i];
            for(int j=i;j<array.length;j++){
                if(array[j]<min){
                    flag=true;
                    min=array[j];
                    index=j;
                }
            }
            if(flag) {
                temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
            flag=false;
        }
    }

}
