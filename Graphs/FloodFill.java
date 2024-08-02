package Graphs;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prevColor=image[sr][sc];
        dfs(image,sr,sc,color,prevColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int prevColor) {
        if(image[sr][sc]==prevColor){
            image[sr][sc]=color; //filling with the color
        }

        //neighbours
        if(sr>0) dfs(image,sr-1,sc,color,prevColor);
        if(sr<image.length-1) dfs(image,sr+1,sc,color,prevColor);
        if(sc>0) dfs(image,sr,sc-1,color,prevColor);
        if(sc<image[0].length) dfs(image,sr,sc+1,color,prevColor);
    }
}
