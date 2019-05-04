import java.util.Scanner;
import java.util.LinkedList;

public class Lexer {

	String str;

	public Lexer(String str){
		this.str = str;
	}

	
	private String getLeaf(String str, int i){
        int j = i;
        for( ; j < str.length(); ) {
            if(Character.isLetterOrDigit(str.charAt(j))) {
                j++;
            } else {
                return str.substring(i, j);
            }
        }
        return str.substring(i, j);
	
	}
		
	
	public LinkedList<String> tokens(){
		
		LinkedList<String> result = new LinkedList();
		
		str = this.str.replaceAll("\\s+",""); // Remove all whitespace
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
					while(str.charAt(i) != (']')){
						i++;
					}
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
		s = "((a,b), (c, d));";
		Lexer lexer = new Lexer(s);
		TreeParser treeparser = new TreeParser();
		tree = treeparser.parse(lexer.tokens());

		System.out.println(tree.n_leaves());  // Should be 4
		System.out.println(tree.height());    // Should be 3
	
	}
}