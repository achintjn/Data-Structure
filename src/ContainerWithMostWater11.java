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
}
