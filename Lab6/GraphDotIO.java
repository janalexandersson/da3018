import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.io.*;
import java.util.Iterator;

public class GraphDotIO{

	public GraphDotIO(){
	
	}
	
	
	public static Graph readDot(String filename) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(filename));
		return readDot(br);
	}
	
	
	public static Graph readDot(BufferedReader br) throws IOException{
		
		String line;
		line = br.readLine();
		List<String[]> edges = new LinkedList<String[]>();
		while (!(line = br.readLine()).equals("}")){
			line = line.replaceAll("\\s+",""); 
			line = line.replaceAll(";",""); 
			String[] pair = line.split("--");
			edges.add(pair);
			//System.out.println(pair[0] + pair[1]);
		} 
	
		
		
		//Find vertices without duplication
		TreeSet<String> vertices = new TreeSet<String>();
		for(String[] p : edges){
			vertices.add(p[0]);
			vertices.add(p[1]);
		}
		
		
		int size = vertices.size();
		int[][] mat = new int[size][size];
		
		Iterator<String> iterator = vertices.iterator();
		
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + "\n");
		}
		

		for(String[] p : edges){
			//v1 and v2 is now the edge as integers
			int v1 = vertices.headSet(p[0]).size();
			int v2 = vertices.headSet(p[1]).size();
			mat[v1][v2] = 1;
			mat[v2][v1] = 1;
		}
		
		
		Graph g = new Graph();
		g.adjMatrix = mat;
		return g;
	}
	
	public static void main(String[] args){
		
		String file;
		
		if(args.length > 0){
			file = args[0];
		} else {
			file = "testgraph.txt";
		}
		
		GraphDotIO gdot = new GraphDotIO();
		Graph g = null;
		try{
			g = gdot.readDot(file);
			}catch(IOException e){
				e.printStackTrace();
			}
			
		g.printAdjMatrix();
	}

}
