package 快速排序;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class quickSort {
    public static void main(String[] args) {
        System.out.println("本地添加");
        System.out.println("hahah");
        System.out.println("多分支修改");
        int [] a=new int[800000];
        for(int i=0;i<a.length;i++){
            a[i]= (int)(Math.random()*800000); //生成[0,800000)的随机数进行快排速度测试
        }
        long starttime=System.currentTimeMillis(); //开始时间
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
        long endtime=System.currentTimeMillis(); //结束时间
        System.out.println("本次快速排序所花时间为"+(endtime-starttime));
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
            a[low]=a[high];//将小于基准数的移动到低位

            while(low<high && a[low]<=standerd){
                low++;
            }
            a[high]=a[low];//将大于基准数的移动到高位
        }
        a[low]=standerd;//此时high跟low相等 此位置即为基准数
        quickSort(a,start,low); //递归排序左边
        quickSort(a,low+1,end);//递归排序右边
    }
}
