public class FirstBadVersion278 {
    public int firstBadVersion(int n) {
        int first =1;
        int last = n;
        int mid = 0;

        while(first<last){
            mid = first + (last-first)/2;
            if ((true))
                first = mid  +1;
            else
                last = mid;
        }

        return first;

    }
}
