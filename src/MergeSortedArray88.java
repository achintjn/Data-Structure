public class MergeSortedArray88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] copy = new int[m];

        for(int i=0; i<m;i++){
            copy[i] = nums1[i];
        }

        int n1 = 0;
        int n2 = 0;
        int i=0;

        while(n1<m || n2<n){
            if(n1==m){
                nums1[i]=nums2[n2];
                n2++;
            }
            else if(n2==n){
                nums1[i]=copy[n1];
                n1++;
            }
            else if(copy[n1]<=nums2[n2]){
                nums1[i]=copy[n1];
                //i++;
                n1++;
            }
            else{
                nums1[i]=nums2[n2];
                //i++;
                n2++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
       merge(nums1,3,nums2,3);

    }
}
