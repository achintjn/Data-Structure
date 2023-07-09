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

    //DP
    public int trapDP(int[] height) {
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        int max = 0;
        for(int i=0;i<size;i++){
            max =  Math.max(max,height[i]);
            left_max[i] = max;
        }
        max = 0;
        for(int i=size-1;i>=0;i--){
            max =  Math.max(max,height[i]);
            right_max[i] = max;
        }
        int trap = 0;
        for(int i=0;i<size;i++){
            trap = trap + (Math.min(left_max[i],right_max[i])-height[i]);
        }

        return trap;
    }
}
