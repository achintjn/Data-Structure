public class ContainerWithMostWater11 {
    //my solution
    public int maxArea(int[] height) {
        int start=0;
        int end=height.length-1;
        int max = 0;
        while(start<end){
            int area=(end-start)*(Math.min(height[start],height[end]));
            max=Math.max(area,max);
            if(height[start]>height[end])
            {
                end--;
            }
            else
                start++;
        }
        return max;
    }
    //revise
    public static int maxArea2(int[] height) {
        int left = 0;
        int right = height.length-1;
        int area = 0;

        while(left<right){
            int curr_area = (right-left)*(Math.min(height[left],height[right]));
            area = Math.max(area, curr_area);
            if(height[right]>height[left])
                left++;
            else
                right--;
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
