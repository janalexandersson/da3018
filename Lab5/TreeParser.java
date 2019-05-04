import java.util.LinkedList;

public class TreeParser {

	public TreeParser() {
	
	}

	public TreeNode parse( LinkedList<String> tokens ){

		String token = tokens.getFirst();
		
		//Leaf
		if(token != "("){
			TreeNode leaf = new TreeNode();
			leaf.value = token;
			tokens.removeFirst(); //Remove the leaf token.
			return leaf;
		}

		else{ //We have read a '('
			tokens.removeFirst(); // remove the '('
			
			TreeNode left = parse( tokens );

			tokens.removeFirst(); //Remove the ','

			TreeNode right = parse( tokens );

			tokens.removeFirst(); //Remove the ')'

			TreeNode parent = new TreeNode();
			parent.left = left;
			parent.right = right;

			return parent;
		} 
	}

}
