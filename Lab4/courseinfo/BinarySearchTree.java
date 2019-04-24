//BinarySearhTree

package courseinfo;

/**
 * Store course information in a binary search tree
 * 
 */
public class BinarySearchTree {
	BSTNode root=null;
	
	public BinarySearchTree() {
		// Empty constructor?
	}
	
	/**
	 * Public interface for inserting data into the datastructure. Utilizes 
	 * a private, more technical method.
	 * @param courseCode, eg "DA3018"
	 * @param courseName, eg "Computer Science"
	 * @param courseCredits, eg 7,5
	 */
	public void insert(String courseCode, String courseName, double courseCredits) {
		BSTNode node = new BSTNode(courseCode, courseName, courseCredits);
		root = insert(root, node);
	}
	
	/**
	 * Insert 'node' into the tree pointed at by 'root'.
	 * @returns The node that should be the root of this subtree.
	 * @param root
	 * @param node
	 * 
	 * WARNING! This method has a bug, it does not behave according to specification!
	 */
	public BSTNode insert(BSTNode root, BSTNode node) {
		if (root==null) {
			return node; // The easy case. Let the current node be the root of a new (sub?)tree.
		} else {
			String currentKey = root.getCourseCode();
			BSTNode left = root.getLeftChild();
			BSTNode right = root.getRightChild();
			if (node.getCourseCode().compareTo(currentKey) < 0) { // left string "before" right string
				left = insert(left, node);
			} else if (node.getCourseCode().compareTo(currentKey) > 0) { // left string "after" right string
				right = insert(right, node);   //Fixed bug here. Prevoius code: right = insert(left, node);
			}
			
			root.setChildren(left, right);
			return root;
		}
	}
	
	/**
	 * size: Count the number of nodes in the search tree
	 */
	
	public int sizeSub(BSTNode root){ //Size of subtree given a new root
	
		if(root == null){
		
			return 0;
			
		} else {
		
			return (sizeSub(root.getLeftChild()) + sizeSub(root.getRightChild()) + 1); 
			//Using recursion to fins size of new subtrees until leaf.
				
		}
	}
	
	public int size() { //Running recusrive size of subtrees
	    
		return sizeSub(root);
		
	}
	
	/**
	 * find: Find a course given a course code
	 */
	 
	 
	 //HELP FUNCTION FOR FIND
	 private BSTNode recursiveFind(String courseCode, BSTNode root){
			BSTNode newRoot = null;
			
			if (root==null) {
				return null; 
				
			} else {
				if (root.getCourseCode().compareTo(courseCode) > 0) { 
					newRoot = root.getLeftChild();
					return recursiveFind(courseCode, newRoot);
				} else if (root.getCourseCode().compareTo(courseCode) < 0) { 
					newRoot = root.getRightChild();
					return recursiveFind(courseCode, newRoot);
				}else{
					return root;
				}
			}
		}
	 
	public BSTNode find(String courseCode) {
		BSTNode possibleNode = recursiveFind(courseCode, root);
		if ( possibleNode != null){
			return possibleNode;
		}else{
			//System.out.println("Not in database");
			//try catch
			throw new NullPointerException("Not in database");
		}
	}
	
	
	
	
	/**
	 * 
	 * Remove a course given a course code
	 * 
	 */
	
	private BSTNode findSmallestElem(BSTNode root) {
		if (root.getLeftChild() == null)
			return root;
		else {
			return findSmallestElem(root.getLeftChild());
		}
	}	
	
	
	private BSTNode removeNode(BSTNode root, String courseCode) {
		if (root == null)
			return null;
		if (root.getCourseCode().compareTo(courseCode) > 0) {
			root.setChildren(removeNode(root.getLeftChild(), courseCode), root.getRightChild());
			
		} else if (root.getCourseCode().compareTo(courseCode) < 0) {
			root.setChildren(root.getLeftChild(), removeNode(root.getRightChild(), courseCode));
			
		} else {
			// The case where the node we want removed has both children
			if (root.getLeftChild() != null && root.getRightChild() != null) {
				BSTNode temp = root;
				// Finding smallest element node from right
				BSTNode minNodeForRight = findSmallestElem(temp.getRightChild());
				// Replacing current node with smallest element node from right subtree
				root.courseCode = minNodeForRight.getCourseCode();
				root.courseName = minNodeForRight.getCourseName();
				root.credits = minNodeForRight.getCredits();
				// Deleting smallest element node from right
				root.setChildren(root.getLeftChild(),removeNode(root.getRightChild(), minNodeForRight.getCourseCode()));
 
			}
			// The case where the node we want removed has only left child
			else if (root.getLeftChild() != null) {
				root = root.getLeftChild();
			}
			// The case where the node we want removed has only left child
			else if (root.getRightChild() != null) {
				root = root.getRightChild();
			}
			// The case where the node we want removed is a leaf
			else
				root = null;
		}
		return root;
	}
	
	public void remove(String courseCode) {
		root = removeNode(root, courseCode);
	}
	
	/**
	 * Nodes in the search tree
	 * This class should be sufficient for the project.
	 * 
	 */
	public class BSTNode {
		private String courseCode;
		private String courseName;
		private double credits;
		private BSTNode left = null;
		private BSTNode right = null;
		
		/**
		 * Constructor
		 * 
		 */
		public BSTNode(String code, String name, double credits) {
			this.courseCode = code;
			this.courseName = name;
			this.credits = credits;
		}
		
		/**
		 * Specify the children of the current node
		 * @param left
		 * @param right
		 */
		public void setChildren(BSTNode left, BSTNode right) {
			this.left = left;
			this.right = right;
		}

		public String getCourseCode() {
			return courseCode;
		}

		public String getCourseName() {
			return courseName;
		}

		public double getCredits() {
			return credits;
		}

		public BSTNode getLeftChild() {
			return left;
		}

		public BSTNode getRightChild() {
			return right;
		}

		
		
	}
}