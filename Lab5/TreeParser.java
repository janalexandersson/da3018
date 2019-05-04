import java.util.LinkedList;

public class TreeParser {

	public TreeParser() {
	
	}

	public TreeNode parseTree( LinkedList<String> tokens ){

		String token = tokens.getFirst();

		tokens.removeFirst(); //Remove the token.


		//Leaf
		if(token != "("){
			TreeNode leaf = new TreeNode();
			leaf.token = token;
			tokens.removeFirst(); //Remove the leaf token.
			return leaf;
		}

		else{ //We have read a '('
			TreeNode left = parseTree( tokens );

			tokens.removeFirst(); //Remove the ','

			TreeNode right = parseTree( tokens );

			tokens.removeFirst(); //Remove the ')'

			TreeNode parent = new TreeNode();
			parent.left = left;
			parent.right = right;

			return parent;
		
		
		} 
	}

}