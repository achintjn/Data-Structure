public class UniquePaths62 {

        public int uniquePaths(int m, int n) {

            int[][] arr= new int[m][n];
            //Arrays.fill(arr,-1);
            int x=0,y=0;
            if(m==1 && n==1)
                return 1;
            if(m>1)
                x=uniquePaths(0+1,0,arr);
            if(n>1)
                y=uniquePaths(0,0+1,arr);
            return x+y;
        }

        public int uniquePaths(int i, int j, int[][] arr){
            if(i==arr.length-1 && j==arr[0].length-1)
                return 1;
            if(i==arr.length-1)
                return uniquePaths(i,j+1,arr);
            if(j==arr[0].length-1)
                return uniquePaths(i+1,j,arr);
            if(arr[i][j]!=0)
                return arr[i][j];
            arr[i][j]= uniquePaths(i+1,j,arr) + uniquePaths(i,j+1,arr);

            return arr[i][j];


    }
}
