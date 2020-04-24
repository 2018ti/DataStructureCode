package 图;

import java.util.ArrayList;

public class GraphDemo {
    public static void main(String[] args) {
        Graph graph = new Graph(new ArrayList<>(), 5);
        String vertexs[]={"A","B","C","D"};
        for(String vertex : vertexs){
            graph.insert(vertex);
        }
        graph.insertGraph(0,1,1);
        graph.insertGraph(0,2,1);
        graph.insertGraph(1,2,1);
        graph.insertGraph(1,3,1);
        graph.insertGraph(1,4,1);
        graph.printGraph();
        graph.dfs();
    }

}

class Graph{
    ArrayList<String> Vertex;
    int m;
    int[][] weights;
    int numOfVertex;
    private boolean[] visited;

    public Graph(ArrayList<String> vertex, int m) {
        Vertex = vertex;
        this.m=m;
        weights=new int[m][m];
        this.visited=new boolean[m];
    }

    public void insert(String vertex){
        Vertex.add(vertex);
    }

    public void insertGraph(int a,int b,int weight){
        weights[a][b]=weight;
        weights[b][a]=weight;
    }

    public int getFirstNeighbor(int index){
        for(int i=0;i<Vertex.size();i++){
            if(weights[index][i]!=0){
                return i;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1,int v2){
        for(int j=v2+1;j<Vertex.size();j++){
            if(weights[v1][j]!=0){
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历
    private void  dfs(boolean[] visited,int i){
        System.out.print(Vertex.get(i)+"->");
        visited[i]=true;
        int w=getFirstNeighbor(i);
        while(w!=-1){
            if(!visited[w]){
                dfs(visited,w);
            }
            w=getNextNeighbor(i,w);
        }
    }

    //重载dfs方法遍历所有节点
    public  void dfs(){
        for(int i=0;i<Vertex.size();i++){
            if(!visited[i]){
                dfs(visited,i);
            }
        }
    }

    public void printGraph(){
//       for(int[] a : weights){
//           System.out.println(a.toString());
//       }
       for(int i=0;i<m;i++){
           for(int j=0;j<m;j++){
               System.out.print(weights[i][j]+" ");
           }
           System.out.println();
       }
    }
}