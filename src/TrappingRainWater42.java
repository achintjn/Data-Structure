public class TrappingRainWater42 {

    //two pointer
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;

        int left_max = height[left];
        int right_max = height[right];
        int trap = 0;
        while(left<right){
            if(left_max<right_max){
                trap = trap + (left_max-height[left]);
                left++;
                left_max = Math.max(left_max,height[left]);
            }else{
                trap = trap + (right_max - height[right]);
                right--;
                right_max = Math.max(right_max,height[right]);
            }
        }
        return trap;
    }
}
