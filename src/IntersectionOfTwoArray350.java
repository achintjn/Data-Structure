import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class IntersectionOfTwoArray350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0;
        List<Integer> list = new ArrayList<>();

        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j])
                i++;
            else if(nums1[i] > nums2[j])
                j++;
        }

        int[] arr = new int[list.size()];
        int x=0;
        for(int a:list)
        {
            arr[x] = a;
            x++;
        }

        return arr;
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<nums1.length; i++)
        {
            if(map.containsKey(nums1[i]))
            {
                int val = map.get(nums1[i]);
                map.put(nums1[i],++val);

            }
            else
                map.put(nums1[i],1);
        }

        for(int j=0; j<nums2.length; j++){
            if(map.containsKey(nums2[j]))
            {
                int val = map.get(nums2[j]);
                if(val>0){
                    list.add(nums2[j]);
                    map.put(nums2[j],--val);
                }
            }
        }

        int[] arr = new int[list.size()];
        int x=0;
        for(int a:list)
        {
            arr[x] = a;
            x++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int []arr = {1,2,2,1};
        int []arr2 = {2,2};

        int []arr3 = intersect2(arr,arr2);

        for(int i:arr3)
            System.out.println(i);
    }
}
