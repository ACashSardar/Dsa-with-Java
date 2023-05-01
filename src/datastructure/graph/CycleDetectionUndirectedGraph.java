package datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int value;
    int parent;
    
    public Node(int value, int parent){
        this.value=value;
        this.parent=parent;
    }
}

public class CycleDetectionUndirectedGraph {
    public boolean cycleDetectionBFS(int start, ArrayList<ArrayList<Integer>> adj, int [] vis){
    	
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(start, -1));
        vis[start]=1;
        
        while(!q.isEmpty()){
            int node=q.peek().value;
            int parent=q.peek().parent;
            q.poll();
            
            for(int adjNode: adj.get(node)){
                if(vis[adjNode]!=1){
                    q.add(new Node(adjNode, node));
                    vis[adjNode]=1;
                }
                else if(adjNode!=parent){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean cycleDetectionDFS(int start, int parent, ArrayList<ArrayList<Integer>> adj, int [] vis){
        
    	vis[start]=1;
        for(int adjNode: adj.get(start)){
            if(vis[adjNode]!=1){
                if(cycleDetectionDFS(adjNode, start, adj, vis)==true)
                    return true;
            }
            else if(adjNode!=parent){
                return true;
            }
        }
        return false;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[]=new int [V];
        for(int i=0; i<V; i++){
            if(vis[i]!=1){
                if(cycleDetectionBFS(i, adj, vis)==true) 
                    return true;
//                if(cycleDetectionDFS(i, -1, adj, vis)==true) 
//                    return true;
            }
        }
        return false;
    }
	public static void main(String[] args) {
		

	}

}
