public class Simulation{
	
	public static void main(String[] args){
	
		final Object[][] table = new String[10][];
		
		table[0] = new String[] {"Probability" , "Mean"};
		
		for(int i = 1; i <= 9; i++){
			
			double val = (double) i/10;
			
			int j = 0;
			
			double mean = 0.0;
			
			while(j < 100){
			
				Graph g = new Graph(100, val);
				
				if(g.isDisconnected() == false){
				
					mean = mean + g.diameter();
					
					j++;
					
				}
			
			}
			
			table[i] = new String[] {String.valueOf(val) , String.valueOf(mean/100)};
			
		}

		for (final Object[] row : table) {
		
			System.out.format("%15s%15s\n", row);
			
		}
		
		
	}

}
