import java.util.Scanner;
import java.util.LinkedList;

public class Lexer {

	private String tokenString;

	public Lexer(String str){
		tokenString = str;
	}
	
	
	private String getLeaf(String s, int i){
		int j = i;
		
		while(j < s.length()) {
			String letter = s.substring(j,j+1);
			if( letter.matches("[a-zA-Z0-9_-]") ) {
			
// 			char letter = s.charAt(j);
// 			if( Character.isLetterOrDigit(letter) || letter.matches("-") ) {
				j++;
			} else {
				return s.substring(i, j);
			}
		}
		return s.substring(i, j);
	}
		
	
	public LinkedList<String> tokens() {
		
		LinkedList<String> result = new LinkedList();
		
		
		//These should be O(n)
		String str = tokenString.replaceAll("\\s+",""); // Remove all whitespace
		str = str.replaceAll("\\[[^\\]]*\\]",""); // Remove all comments
		
		for(int i = 0; i < str.length();){
			switch(str.charAt(i)) {
				case '(':
					result.add("(");
					i++;
					break;
				case ')':
					result.add(")");
					i++;
					break;
				case ',':
					result.add(",");
					i++;
					break;
				case ';':
					result.add(";");
					i++;
					break;
				case ':':
					result.add(":");
					i++;
					break;
				case '[': //The comment case
					i++;
// 					while(str.charAt(i) != (']')) {
// 						i++;
// 					}
					
					for(;str.charAt(i) != (']');i++);
					
					i++;
					break;
				default:
					String substring = getLeaf(str, i);
					i += substring.length();
					result.add(substring);
					break;
			}
		}		
		return result;
	}
	
	public static void main(String[] args){
 		
 		String s = null;
 		
 		s = "( (3, (1, 2))  ,  (((((4, 5), 6), 8), 7), 9) );"; //9, 7
 		
 		s = "apa;"; // 1,1
 		
 		s = "(apa,gnu);"; // 2,2
 		
 		s = "(a[hej]pa,gnu);"; // 2,2
 		s = "(a[hej]pa,g[124]n[]u);"; // 2,2
 		
//  	s = "(apa,gnu[[[3462]]]);"; // Undefined behavior?
 		
 		
 		Lexer lexer = new Lexer(s);
 		
//  		for(String t : lexer.tokens()) {
// 			System.out.println("token: '" + t + "'");
// 		}
 		
 		TreeParser treeparser = new TreeParser();
 		TreeNode tree = treeparser.parse(lexer.tokens());
// 
 		System.out.println("n_leaves: " +  tree.n_leaves());
 		System.out.println("height: " + tree.height());    
	
	}
}
