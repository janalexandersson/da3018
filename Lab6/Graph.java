
import java.util.Random;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.Arrays;
import java.util.Collections;

public class Graph{

	public int[][] adjMatrix;

	public Graph() {
		
	}

	public Graph(int n, double p){
		this.adjMatrix = new int[n][n];
		this.random(n,p);
	}
	
	
	public void random(int n, double p) {
		Random rand =	new Random();
		
        if (p < 0.0 || p > 1.0){
            throw new IllegalArgumentException("Not a probability");
		}
		
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                if (rand.nextDouble() < p){
                    this.adjMatrix[i][j] = 1;
                    this.adjMatrix[j][i] = 1;
				}

			}
		}
    }
	
	public int[][] getAdjMatrix(){
		return this.adjMatrix;
	}
	
	
	public LinkedList<Integer> getNeightbors(int index){
		LinkedList<Integer> neighbors = new LinkedList<Integer>();
		int n = this.adjMatrix.length;
		for(int i = 0; i < n; i++){
			if(this.adjMatrix[index][i] == 1){
				neighbors.add(i);
			}
		}
		return neighbors;
	}
	
	
	
	
	public int[] distance(int index) {
		int n = this.adjMatrix.length;
		int[] dist = new int[n];
		
		Arrays.fill(dist, -1);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		dist[index] = 0;
		queue.add(index);
		
		while(!queue.isEmpty()){
		
            int current = queue.poll(); 
       
            for (int nb : this.getNeightbors(current)) {
				if(dist[nb] < 0){
					queue.add(nb);
					dist[nb] = 1 + dist[current];
				}
			} 
		}
		return dist;
    }
	
	
	public boolean isDisconnected(){
		int[] disconnectedTest = this.distance(0);
		for(int i=0; i<disconnectedTest.length; i++){
			if(disconnectedTest[i] < 0){
				return true;
			}
		}
		return false;
	}
	
	
	
	public int diameter(){
		int n = this.adjMatrix.length;
		int dia = 0;
		
		if(this.isDisconnected() == true){
			return -1;
		}else{
			for(int i=0; i<n; i++){
				
				int[] x = this.distance(i);
				
				for(int j=0; j<n; j++){
					if(x[j] > dia ){
						dia = x[j];
					}
				}
			}
		}
		return dia;
	}
	
	
	public void printAdjMatrix(){
		
		for (int i = 0; i < this.adjMatrix.length; i++) {         //this equals to the row in our matrix.
         for (int j = 0; j < this.adjMatrix[i].length; j++) {   //this equals to the column in each row.
            System.out.print(this.adjMatrix[i][j] + " ");
         }
         System.out.println(); //change line on console as row comes to end in the matrix.
		}  
	
	}
	
	
	
	
	public static void main(String[] args){
 		
 		
 		Graph graph = new Graph(15,0.3);
		
		
		
		System.out.println();
		System.out.println();
		
		int[][] test = graph.getAdjMatrix();
				
		
		int[] testdist = graph.distance(1);
		for (int i = 0; i < test.length; i++) {
			System.out.println(testdist[i]);
		}
		
		
		System.out.println();
		System.out.println();
		
		System.out.println(graph.diameter());
		
	}

}
