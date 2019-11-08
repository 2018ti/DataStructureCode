package 排序算法.冒泡排序;

import java.util.Scanner;

public class help {
    public static void main(String[] args) {
       int n;
       int x;
       int r;
       int count=0;
        Scanner in= new Scanner(System.in);
       n=in.nextInt();
       x=in.nextInt();
       int p;
       for(int i=1;i<=n;i++){
           p=i;
           while(p!=0){
               r=p%10;
               p/=10;
               if(r==x){
                   count++;
               }
           }
       }
        System.out.println(count);
    }
}
