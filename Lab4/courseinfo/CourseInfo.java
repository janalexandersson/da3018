//CourseInfo

package courseinfo;


import java.util.NoSuchElementException;
import java.util.Iterator;

public class CourseInfo {

	public static void main(String[] args) {
		BinarySearchTree courses = new BinarySearchTree();
		
		//courses.insert("DA3018", "Computer Science", 7.5);
		//courses.insert("MM2001", "Matematik I", 30.0);
		//courses.insert("DA2004", "Programmeringsteknik", 7.5);
		courses.insert("1", "1", 7.5);
		courses.insert("2", "2", 7.5);
		//courses.insert("7", "7", 7.5);
		courses.insert("4", "4", 7.5);
		courses.insert("3", "3", 7.5);
		courses.insert("5", "5", 7.5);
		
		System.out.println(courses.root.getCourseName());
		System.out.println(courses.root.getRightChild().getCourseName());
		System.out.println(courses.find("2").getCourseName());
		System.out.println(courses.find("4").getRightChild().getCourseName());
		System.out.println(courses.find("4").getLeftChild().getCourseName());
		
		courses.remove("1");
		
		//System.out.println(courses.find("5").getRightChild().getCourseName());
		
		System.out.println(courses.size());
		
		
		
		
		
		for (BinarySearchTree.BSTNode node: courses) {
			System.out.println(node.getCourseCode());
		}
		
		
		
		// Use iterator to display contents of al
     // System.out.print("Original contents of al: ");
     // Iterator itr = courses.iterator();
      
      
      /**
      while(itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element.getCourseCode() + "\n");
      }

		
		/**
		System.out.println(courses.find("5").getLeftChild().getCourseName());
		System.out.println(courses.find("5").getRightChild().getCourseName());
		System.out.println(courses.find("4").getLeftChild().getCourseName());
		
		courses.remove("4");
		//System.out.println(courses.find("4").getLeftChild().getCourseName());
		//System.out.println(courses.find("4").getRightChild().getCourseName());
		System.out.println(courses.find("5").getLeftChild().getCourseName());
		
		int n = courses.size();
		System.out.printf("There are %d courses in the database.\n", n);
		
		System.out.println(courses.root.getCourseName());
		
		String name = courses.find("4").getCourseName();
		System.out.printf("Name: %s\n", name);
		System.out.println(courses.root.getCourseName());'
		*/
	}

}
