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


    //concise and accurate solution
    public int minEatingSpeed2023(int[] piles, int h) {

        int max = 0;
        for(int a:piles)
            max = Math.max(max,a);

        int start = 1;
        int end = max;

        while(start<end){
            int k = start + (end-start)/2;
            int h0=0;
            for(int pile:piles){
                h0 = h0 + (int)Math.ceil((double)pile/k);
            }
            if(h0>h)
                start = k+1;
            else if(h0<=h)
                end = k;
        }

        return end;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{1000000000},2));
    }
}
