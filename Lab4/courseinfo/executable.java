
package courseinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class executable {

	public static void main(String[] args) throws FileNotFoundException {
		
		BinarySearchTree courses = new BinarySearchTree();
		
		String csv = args[0];
		
		Scanner scanner = new Scanner(new File(csv));
        
        while(scanner.hasNextLine()){
            
            String[] input = scanner.nextLine().split(",");
            
			courses.insert(input[0], input[1], Double.parseDouble(input[2]));
            
        }
        
        scanner.close();
        
		Double sum = 0.0;
        
        if(args.length == 1){
			
			for (BinarySearchTree.BSTNode node: courses){
				
				System.out.println(node.getCourseCode() + " " + node.getCourseName() + " " + node.getCredits()+"hp");
				
				sum = sum + node.getCredits();
			}
			
			
		} else {
		
			for (int i = 1; i < args.length; i++) {
			
				BinarySearchTree.BSTNode node = courses.find(args[i]);
				
				System.out.println(node.getCourseCode() + " " + node.getCourseName() + " " + node.getCredits()+"hp");
				
				sum = sum + node.getCredits();
				
			}		
			
		}
		
		System.out.println("Sum: " + sum);
	}

}

