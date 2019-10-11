package 查找算法;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class halfSearch {
    public static void main(String[] args) {
        int[] arr={1,2,3,6,8,9,10,45,49};
        int index= halfSearch(arr,0,arr.length-1,8);
        if(index!=-1){
            System.out.println(index);
        }else System.out.println("未找到");
    }
    public static int halfSearch(int[] arr,int left,int right,int value){
        int mid=(left+right)/2;

        if(arr[mid]==value){
            return mid;
        }
        if(right==left){
            return -1;
        }else if(value>arr[mid]){
            return halfSearch(arr,mid+1,right,value);
        }else if(value<arr[mid]){
            return halfSearch(arr,0,mid-1,value);
        }

        return -1;
    }
}
