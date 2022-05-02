/*
public class SquareAndSort {

    public static int[] sortedSquares(int[] nums) {

        boolean flag = true;
        boolean flag2 = true;
        int posIndex = 0;
        int index = 0;
        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length;i++)
        {
            if(nums[i]>=0 && flag == true)
            {
                flag = false;
                posIndex = i;
            }
            nums[i] = nums[i] * nums[i];
        }

        int back = posIndex-1;
        while(flag2)
        {
            int i=0;
            if(nums[posIndex]<nums[back] && )
            {
                arr[index++] = nums[posIndex];
                if(posIndex!=nums.length-1)
                    posIndex++;
            }

            else if(nums[posIndex]>nums[back])
            {
                arr[index++] = nums[back];
                if(back!=0)
                    back--;
            }

            else if(nums[posIndex]==nums[back])
            {
                arr[index++] = nums[posIndex];
                arr[index++] = nums[back];
                posIndex++;
                back--;
            }

            if(index == nums.length-1)
                flag2 = false;

            if(back == 0 && posIndex< nums.length)

        }
        System.out.println(posIndex);

        return arr;
    }

    */
/*public static void main(String[] args) {
        int [] numbers = {-3,-2,0,6,9};
        int [] squared = sortedSquares(numbers);
        for(int sns : squared)
        {
            System.out.println(sns);
        }*//*

    }
}
*/
