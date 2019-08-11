class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    num += dfs(grid,i,j);
                }
            }
        }
        return num;
    }
    
    private int dfs(char [][] grid,int r,int c){
        if(grid[r][c] =='0' || c>= grid[0].length || c<0 || r>=grid.length || r<0){ 
            return 0;
        }
        grid[r][c] = 0;
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        return 1;
    }
}
