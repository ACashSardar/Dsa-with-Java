package algorithm.backtracking;

import java.util.ArrayList;

public class RatInAMaze {
    public static void ratInMaze(int x, int y, int[][] arr, int n, String path, boolean[][] visited, ArrayList<String> ans){
        if(x<0 || y<0) return;
        if(x==0 && y==0){
            ans.add(path);
        }
        
        if(y>0 && visited[x][y-1]==false && arr[x][y-1]==1){
            visited[x][y]=true;
            ratInMaze(x, y-1, arr, n, path+'D',visited, ans);
            visited[x][y]=false;
        }
        
        if(x<n-1  && visited[x+1][y]==false && arr[x+1][y]==1){
            visited[x][y]=true;
            ratInMaze(x+1, y, arr,n, path+'L',visited, ans);
            visited[x][y]=false;
        }
        
        if(x>0 && visited[x-1][y]==false && arr[x-1][y]==1){
            visited[x][y]=true;
            ratInMaze(x-1, y, arr,n, path+'R',visited, ans);
            visited[x][y]=false;
        }
        
        if(y<n-1  && visited[x][y+1]==false && arr[x][y+1]==1){
            visited[x][y]=true;
            ratInMaze(x, y+1, arr, n, path+'U',visited, ans);
            visited[x][y]=false;
        }
    
}
	public static void main(String[] args) {
		int n=5;
        ArrayList<String> ans=new ArrayList<>();
        boolean [][] visited=new boolean[n][n];
//        ratInMaze(n-1, n-1, arr,n, "",visited, ans);
	}

}
