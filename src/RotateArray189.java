import java.util.Arrays;

public class RotateArray189 {
    public static void rotate(int[] nums, int k) {
        int len = nums.length-1;

        reverse(nums,0,len);
        reverse(nums,0,k-1);
        reverse(nums,k, len);
    }

    public static void reverse(int [] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int [] arr = {-1,-100,3,99};
        rotate(arr,2);
        System.out.println(Arrays.toString(arr));
    }
}
