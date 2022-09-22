public class KokoEatingBananas875 {
    public static int minEatingSpeed(int[] piles, int h) {
        int start =1;
        int end = 1;
        for(int pile:piles)
            end = Math.max(pile, end);

        while(start<end){
            int mid = start + (end-start)/2;
            int hrs = calculate(piles,mid);
            if(hrs<=h)
                end=mid;
            else
                start=mid+1;
        }
        return end;
    }

    public static int calculate(int[] piles, int num){
        int a=0;
        for(float pile:piles){
            a=a+(int)Math.ceil((double)pile/num);
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{1000000000},2));
    }
}
