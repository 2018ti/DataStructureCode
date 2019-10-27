package 查找算法;
import java.util.HashMap;
import java.util.Map;

public class firstWork {
    public static void main(String[] args) {
        System.out.println("多分支同时修改");
        int[] arr={1,2,4,6,7,8,10,24,35,40};
        Map map = BinarySearch(arr,0,arr.length-1,11);
        if(map.get("true")!=null){
            System.out.println("找到元素 元素下标为"+map.get("true"));
        }else {
            System.out.println("比该元素小的最大下标为"+map.get("SmallThanValue"));
            System.out.println("比该元素大的最小坐标为"+map.get("bigThanValue"));
        }
    }

    public static Map BinarySearch(int arr[],int left,int right,int value){
        int mid=(left+right)/2;
         if(arr[mid]==value){
             HashMap<String, Integer> result = new HashMap<>();
             result.put("true",mid);
             return result;
         }else if(left>right){
             if(arr[left]>value) {
                 HashMap<String, Integer> result = new HashMap<>();
                 result.put("SmallThanValue",left-1);
                 result.put("bigThanValue",left);
                 return result;
             }
             else {
                 HashMap<String, Integer> result = new HashMap<>();
                 result.put("SmallThanValue",left);
                 result.put("bigThanValue",left+1);
             };
         }
         else if(arr[mid]>value){
            return BinarySearch(arr,left,mid-1,value);
        }else if(arr[mid]<value){
            return BinarySearch(arr,mid+1,right,value);
        }
        HashMap<String, Integer> result = new HashMap<>();
         result.put("false",0);
         return result;
    }

}
