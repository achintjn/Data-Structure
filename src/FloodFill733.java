import java.util.Arrays;

public class FloodFill733 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;

        int[][] adj = {{0,1},{0,-1},{1,0},{-1,0}};

        for(int i=0;i<=3;i++){
            dfs(image,sr,sc,adj[i][0],adj[i][1], oldColor, newColor);

        }

        return image;
    }

    public static void dfs(int[][] image2, int sr, int sc,int a, int b, int oldColor, int newColor){
        if(sr+a<0 || sc+b<0)
            return;
        if(sr+a>=image2.length || sc+b>=image2[0].length){
            System.out.println(image2[0].length);
            System.out.println(image2.length);
            return;
        }


            if(image2[sr+a][sc+b]==oldColor){
                image2[sr+a][sc+b] = newColor;

                int[][] adj = {{0,1},{0,-1},{1,0},{-1,0}};

                for(int i=0;i<=3;i++){
                    dfs(image2,sr+a,sc+b,adj[i][0],adj[i][1], oldColor, newColor);

                }
            }

    }


    public static void main(String[] args) {

        int[][] image = {{0,0,0},{0,0,0}};

        image = floodFill(image,0,0,2);

        System.out.println(Arrays.deepToString(image));
    }

}

